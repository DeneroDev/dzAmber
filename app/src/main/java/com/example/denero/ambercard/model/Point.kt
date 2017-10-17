package com.example.denero.ambercard.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by DENERO on 16.10.2017.
 */
class Point {
    @SerializedName("id")
    @Expose
    private val id: Int? = null
    @SerializedName("name")
    @Expose
    private val name: String? = null
    @SerializedName("category_id")
    @Expose
    private val categoryId: List<Int>? = null
    @SerializedName("description")
    @Expose
    private val description: String? = null
    @SerializedName("description_2")
    @Expose
    private val description2: String? = null
    @SerializedName("latitude")
    @Expose
    private val latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    private val longitude: Double? = null
    @SerializedName("rate")
    @Expose
    private val rate: String? = null
    @SerializedName("cost_sum")
    @Expose
    private val costSum: String? = null
    @SerializedName("cost_text")
    @Expose
    private val costText: String? = null
    @SerializedName("phone")
    @Expose
    private val phone: String? = null
    @SerializedName("site")
    @Expose
    private val site: String? = null
    @SerializedName("discount_min")
    @Expose
    private val discountMin: String? = null
    @SerializedName("discount_max")
    @Expose
    private val discountMax: String? = null
    @SerializedName("discount_conditions")
    @Expose
    private val discountConditions: String? = null
    @SerializedName("min_people")
    @Expose
    private val minPeople: Int? = null
    @SerializedName("max_people")
    @Expose
    private val maxPeople: Int? = null
    @SerializedName("photos")
    @Expose
    private val photos: List<String>? = null
}