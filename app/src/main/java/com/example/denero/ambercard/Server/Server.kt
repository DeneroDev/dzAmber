package com.example.denero.ambercard.Server

import com.example.denero.ambercard.model.PagePOJO
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



/**
 * Created by DENERO on 16.10.2017.
 */
class Server() {
    val BASE_URL = "http://138.68.68.166:9999"
    val moshi = Moshi.Builder().build()
    val builder = GsonBuilder()
    val gson = builder.create()
    var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    var req: ServerAPI = retrofit.create(ServerAPI::class.java)
    val jsonAdapter = moshi.adapter(PagePOJO::class.java)




}