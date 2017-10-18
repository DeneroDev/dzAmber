package com.example.denero.ambercard.Repository.POJO

import com.squareup.moshi.Json



/**
 * Created by DENERO on 12.10.2017.
 */
class Category {
    @Json(name = "id")
    var id: Int? = null
    @Json(name = "name")
    var name: String? = null
    @Json(name = "icon")
    var icon: String? = null
    @Json(name = "picture")
    var picture: String? = null
}
