package com.example.denero.ambercard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by DENERO on 12.10.2017.
 */
class PagePOJO {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("category_id")
    @Expose
    var categoryId: List<CategoryId>? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("description_2")
    @Expose
    var description2: String? = null
    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null
    ///sadaszxcz

    @SerializedName("rate")
    @Expose
    var rate: String? = null
    @SerializedName("cost_sum")
    @Expose
    var costSum: String? = null
    @SerializedName("cost_text")
    @Expose
    var costText: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("site")
    @Expose
    var site: String? = null
    @SerializedName("discount_min")
    @Expose
    var discountMin: String? = null
    @SerializedName("discount_max")
    @Expose
    var discountMax: String? = null
    @SerializedName("discount_conditions")
    @Expose
    var discountConditions: String? = null
    @SerializedName("min_people")
    @Expose
    var minPeople: Any? = null
    @SerializedName("max_people")
    @Expose
    var maxPeople: Any? = null
    @SerializedName("photos")
    @Expose
    var photos: List<String>? = null
}
