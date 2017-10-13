package com.example.denero.ambercard

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.Toolbar
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.denero.ambercard.model.JsonGet
import com.example.denero.ambercard.model.PagePOJO
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import java.util.*

/**
 * Created by DENERO on 12.10.2017.
 */
class PlaceActivity : AppCompatActivity() {

    // Вынести всё по слоям, использовав, например MVP подход или любой другой


    private val jsonGet = JsonGet()
    private val BASE_URL = "http://138.68.68.166:9999"
    private val ID_STAR = intArrayOf(R.id.star_one, R.id.star_two, R.id.star_three, R.id.star_four, R.id.star_five)

    // Тут должен быть lateinit, а не optional
    private var YESEVA_ONE: Typeface? = null

    private val builder = GsonBuilder()
    private val gson = builder.create()
    private val page = gson.fromJson<PagePOJO>(jsonGet.jsonTwo, PagePOJO::class.java!!)

    // TODO: В gradle стоит minApi 19, здесь ты требуешь 21. На девайсах меньше 21 будет краш т.к. этот метод они не найдут. Это баг категории blocker - наивысший
    // Возникли проблемы с getDrawable()? Почитай про Support Library, да и в целом про то, почему все ненавидят старые андроиды.
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)

        // Метод сильно перегружен, если нет архитектурных слоёв, то хотя бы разнеси всё на функции

        title = ""
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        val collapsingToolbarLayout = findViewById(R.id.toolbar_layout) as CollapsingToolbarLayout
        collapsingToolbarLayout.contentScrim = getDrawable(R.drawable.backgroundlay)
        setSupportActionBar(toolbar)
        val toolbarImg = findViewById(R.id.main_backdrop_activity) as ImageView

        val descrTitle = findViewById(R.id.title_description) as TextView
        YESEVA_ONE = Typeface.createFromAsset(assets, "YesevaOne-Regular.ttf")
        descrTitle.typeface = YESEVA_ONE

        val descrText = findViewById(R.id.text_description) as TextView
        val descrWorkDay = findViewById(R.id.workday_description) as TextView
        val descrPrice = findViewById(R.id.price_description) as TextView
        val descrPhone = findViewById(R.id.descr_phone) as TextView
        val descrPlace = findViewById(R.id.descr_location) as TextView


        runOnUiThread {
            // Я бы вынес в extension к ImageView
            Picasso.with(applicationContext) //передаем контекст приложения
                    .load(BASE_URL + page!!.categoryId!![0].picture) //адрес изображения
                    .into(toolbarImg) //ссылка на ImageView
            // упрости
            // (0 until Integer.valueOf(page.rate)).forEach {  }
            for (i in 0 until Integer.valueOf(page.rate)) {
                val star = findViewById(ID_STAR[i]) as ImageView
                star.setImageDrawable(getDrawable(R.drawable.ic_star_plus))
            }
        }

        descrTitle.text = page.name
        descrText.text = page.description

        //только не по лицу
        if (page.description2 != null && page!!.description2!!.length >= 2)
            descrWorkDay.text = Html.fromHtml("<b>" + "Режим работы:" + "</b> " + page.description2)
        else {
            // Всё это заменятся на View.GONE
            descrWorkDay.width = 0
            descrWorkDay.height = 0
            descrWorkDay.visibility = View.INVISIBLE
        }

        if (page.costText != null && page.costSum!!.length > 1)
            descrPrice.text = Html.fromHtml("<b>" + page.costText + "</b>" + ": " + page.costSum)
        else {
            descrPrice.width = 0
            descrPrice.height = 0
            descrPrice.visibility = View.INVISIBLE
        }

        if (page.phone != null && page!!.phone!!.length > 1) {
            descrPhone.text = page.phone
        } else {
            val card = findViewById(R.id.tel_card) as CardView
            card.visibility = View.INVISIBLE
        }

        if (page.longitude != null && page!!.phone!!.length > 1) {
            // Используй строки с плейсхолдерами
            descrPlace.text = "Долгота:" + String.format(Locale.ENGLISH, "%(.2f", page.longitude) + " | " + "Широта:" + String.format(Locale.ENGLISH, "%(.2f", page.latitude)
        } else {
            val card = findViewById(R.id.locale_card) as CardView
            card.visibility = View.INVISIBLE
        }
        // setTitle(" ");


    }

    // Зачем v: View
    fun endApplication(v: View) {
        finish()
    }
}