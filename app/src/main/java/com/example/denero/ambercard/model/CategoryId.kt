package com.example.denero.ambercard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by DENERO on 12.10.2017.
 */
class CategoryId {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("picture")
    @Expose
    var picture: String? = null
}
