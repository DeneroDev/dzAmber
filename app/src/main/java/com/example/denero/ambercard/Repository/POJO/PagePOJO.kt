package com.example.denero.ambercard.Repository.POJO


import com.squareup.moshi.Json



/**
 * Created by DENERO on 12.10.2017.
 */
class PagePOJO {
    @Json(name = "id")
    var id: Int? = null
    @Json(name = "name")
    var name: String? = null
    @Json(name = "category_id")
    var categoryId: List<Int>? = null
    @Json(name = "description")
    var description: String? = null
    @Json(name = "description_2")
    var description2: String? = null
    @Json(name = "latitude")
    var latitude: Double? = null
    @Json(name = "longitude")
    var longitude: Double? = null
    @Json(name = "rate")
    var rate: String? = null
    @Json(name = "cost_sum")
    var costSum: String? = null
    @Json(name = "cost_text")
    var costText: String? = null
    @Json(name = "phone")
    var phone: String? = null
    @Json(name = "site")
    var site: String? = null
    @Json(name = "discount_min")
    var discountMin: String? = null
    @Json(name = "discount_max")
    var discountMax: String? = null
    @Json(name = "discount_conditions")
    var discountConditions: String? = null
    @Json(name = "min_people")
    var minPeople: Any? = null
    @Json(name = "max_people")
    var maxPeople: Any? = null
    @Json(name = "photos")
    var photos: List<String>? = null
}
