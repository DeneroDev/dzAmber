package com.example.denero.ambercard.model

import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.Toolbar
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.denero.ambercard.R

/**
 * Created by DENERO on 14.10.2017.
 */
class Views() : AppCompatActivity() {
    //PlaceActivity
        lateinit var descrText:TextView
        lateinit var descrWorkDay:TextView
        lateinit  var descrPrice:TextView
        lateinit  var descrPhone:TextView
        lateinit  var descrPlace:TextView
        lateinit  var categoryText :TextView
        lateinit  var descrTitle:TextView
        lateinit var toolbarImg:ImageView
        lateinit var categoryIcon:ImageView
        lateinit var toolbar:Toolbar
        lateinit var collapsingToolbarLayout:CollapsingToolbarLayout
        lateinit var cardPhone:CardView
        lateinit var cardLocale:CardView
        lateinit var progressBarMain:ProgressBar
    //AuthActivity
        lateinit var userPassword:EditText
        lateinit var userLogin:EditText
    //

    fun setViewsPlaceActivity(app:AppCompatActivity){
        descrText = app.findViewById(R.id.text_description) as TextView
        descrWorkDay = app.findViewById(R.id.workday_description) as TextView
        descrPrice = app.findViewById(R.id.price_description) as TextView
        descrPhone = app.findViewById(R.id.descr_phone) as TextView
        descrPlace = app.findViewById(R.id.descr_location) as TextView
        categoryText = app.findViewById(R.id.category_text) as TextView
        descrTitle = app.findViewById(R.id.title_description) as TextView
        toolbarImg = app.findViewById(R.id.main_backdrop_activity) as ImageView
        categoryIcon = app.findViewById(R.id.category_icon) as ImageView
        toolbar = app.findViewById(R.id.toolbar) as Toolbar
        collapsingToolbarLayout = app.findViewById(R.id.toolbar_layout) as CollapsingToolbarLayout
        cardPhone = app.findViewById(R.id.tel_card) as CardView
        cardLocale = app.findViewById(R.id.locale_card) as CardView
    }
    fun setViewsAuthActivity(app:AppCompatActivity){
        userPassword = app.findViewById(R.id.user_password) as EditText
        userLogin = app.findViewById(R.id.user_login) as EditText
    }
}