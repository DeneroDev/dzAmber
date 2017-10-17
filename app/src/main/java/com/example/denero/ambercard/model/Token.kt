package com.example.denero.ambercard.model

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


/**
 * Created by DENERO on 16.10.2017.
 */
class Token {
    @SerializedName("token")
    @Expose
    var token: String = ""
}