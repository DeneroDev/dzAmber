package com.example.denero.ambercard.View


import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.denero.ambercard.R
import com.example.denero.ambercard.Repository.Server
import com.example.denero.ambercard.model.JsonGet
import com.example.denero.ambercard.Repository.POJO.PagePOJO
import com.example.denero.ambercard.model.Views
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class PlaceActivity() : AppCompatActivity() {
    private val jsonGet = JsonGet()
    private val server = Server()
    private val ID_STAR = intArrayOf(R.id.star_one, R.id.star_two, R.id.star_three, R.id.star_four, R.id.star_five)
    private lateinit var YESEVA_ONE: Typeface
    private val builder = GsonBuilder()
    private val gson = builder.create()
    private val views = Views()
    var id:Int = 0
    lateinit var icon:String
    lateinit var picture:String
    lateinit var name:String
   // private val page = server.jsonAdapter.fromJson(jsonGet.jsonTwo)
    private lateinit var page: PagePOJO /*gson.fromJson<PagePOJO>(jsonGet.jsonTwo, PagePOJO::class.java)*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)
        title = ""
        var sPref  = getSharedPreferences("Token",Context.MODE_PRIVATE)
        id = intent.getIntExtra("id",0)
        icon = intent.getStringExtra("icon")
        picture = intent.getStringExtra("picture")
        name = intent.getStringExtra("name")
        var token = sPref.getString("Token","")
        Log.d("TOKEN",token)
        //Server
        val call: Call<PagePOJO> = server.req.getPointforId(id,"Token "+sPref.getString("token",""))
        call.enqueue(object : Callback<PagePOJO> {
            override fun onResponse(call: Call<PagePOJO>?, response: Response<PagePOJO>?) {
                page = response!!.body()!!
                createScreen()
            }

            override fun onFailure(call: Call<PagePOJO>?, t: Throwable?) {
                Toast.makeText(applicationContext,"FAIL",Toast.LENGTH_LONG)
            }
        })
        ////

    }

    fun endApplication(v:View) {
        finish()
    }
    fun createScreen(){
        views.setViewsPlaceActivity(this)
        views.collapsingToolbarLayout.contentScrim = ContextCompat.getDrawable(this, R.drawable.backgroundlay)
        setSupportActionBar(views.toolbar)
        runOnUiThread {
            if(page.photos!!.get(0)!=null)
                Picasso.with(applicationContext)
                        .load(server.BASE_URL + page.photos!!.get(0))
                        .into(views.toolbarImg)
            if(icon!=null)
                Picasso.with(applicationContext)
                        .load(server.BASE_URL + icon)
                        .into(views.categoryIcon)
            (0 until Integer.valueOf(page.rate)).forEach {
                val star = findViewById(ID_STAR[it]) as ImageView
                star.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_plus))
            }
        }

        YESEVA_ONE = Typeface.createFromAsset(assets, "YesevaOne-Regular.ttf")
        views.descrTitle.typeface = YESEVA_ONE






        views.descrTitle.text = page.name
        views.categoryText.text = name
        views.descrText.text = page.description

        //только не по лицу
        if (page.description2 != null && page.description2!!.length >= 2)
            views.descrWorkDay.text = Html.fromHtml("<b>" + "Режим работы:" + "</b> " + page.description2)
        else {
            views.descrWorkDay.visibility = View.GONE
        }

        if (page.costText != null && page.costText!!.length > 3)
            views.descrPrice.text = Html.fromHtml("<b>" + "Стоимость посещения: " + "</b>" + page.costText+":" + page.costSum)
        else {
            views.descrPlace.visibility = View.GONE
        }

        if (page.phone != null && page.phone!!.length > 1) {
            views.descrPhone.text = page.phone
        } else {
            views.cardPhone.visibility = View.GONE
        }

        if (page.longitude != null && page.longitude.toString()!="") {
            views.descrPlace.text = "Долгота:" + String.format(Locale.ENGLISH, "%(.2f", page.longitude) + " | " + "Широта:" + String.format(Locale.ENGLISH, "%(.2f", page.latitude)
        } else {
            views.cardLocale.visibility = View.GONE
        }


    }
}