package com.example.denero.ambercard.View

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.denero.ambercard.R
import com.example.denero.ambercard.Repository.Server
import com.example.denero.ambercard.Repository.POJO.NPagePOJO
import com.example.denero.ambercard.model.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by DENERO on 17.10.2017.
 */
class AllPointActivity: AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    lateinit var mAdapter: RecyclerView.Adapter<*>
    lateinit var layoutManager:RecyclerView.LayoutManager
    lateinit var myDataset: NPagePOJO
    var server = Server()
    val TOKEN_PREF = "token"
    var flag:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_points)
        recyclerView = findViewById(R.id.all_point_recycler) as RecyclerView
        var sPref  = getSharedPreferences("Token",Context.MODE_PRIVATE)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val call: Call<NPagePOJO> = server.req.getAllPoints("Token "+sPref.getString(TOKEN_PREF,""))
        call.enqueue(object : Callback<NPagePOJO>{
            override fun onFailure(call: Call<NPagePOJO>?, t: Throwable?) {
                Toast.makeText(applicationContext,"FAIL",Toast.LENGTH_LONG).show()
                Log.d("Exeption:",t.toString())
            }

            override fun onResponse(call: Call<NPagePOJO>?, response: Response<NPagePOJO>?) {
                myDataset = response!!.body()!!
                createScreen()
            }
        })

    }

    fun createScreen(){
        mAdapter = RecyclerAdapter(myDataset,applicationContext)
        recyclerView.adapter = mAdapter
    }
}