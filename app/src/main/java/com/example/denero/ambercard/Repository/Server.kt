package com.example.denero.ambercard.Repository

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient




/**
 * Created by DENERO on 16.10.2017.
 */
class Server() {
    val BASE_URL = "http://138.68.68.166:9999"
    val moshi = Moshi.Builder().build()
    var client = OkHttpClient.Builder()
            .build()
    var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    var req: ServerAPI = retrofit.create(ServerAPI::class.java)




}