package com.example.denero.ambercard.Repository.POJO

import com.squareup.moshi.Json





/**
 * Created by DENERO on 17.10.2017.
 */
class NPagePOJO {
    @Json(name = "points")
    var points: List<Point>? = null
    @Json(name = "categories")
    var categories: List<Category>? = null
}