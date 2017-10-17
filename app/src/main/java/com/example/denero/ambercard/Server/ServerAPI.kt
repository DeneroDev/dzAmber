package com.example.denero.ambercard.Server

import com.example.denero.ambercard.model.*
import retrofit2.Call
import retrofit2.http.*

interface ServerAPI {
    @GET("/api/1/content")
    fun getAllPoints(@Header("Authorization")token: String): Call<NPagePOJO>

    @GET("/api/1/point/{id}")
    fun getPointforId(@Path("id")id:Int, @Header("Authorization")token: String):Call<PagePOJO>


    @POST("/api/1/login")
    fun authorizationUser(@Body regisBody: RegisBody):Call<Any>


}