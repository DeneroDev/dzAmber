package com.example.denero.ambercard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by DENERO on 17.10.2017.
 */
class NPagePOJO {
    @SerializedName("points")
    @Expose
    var points: List<PagePOJO>? = null
    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null
}