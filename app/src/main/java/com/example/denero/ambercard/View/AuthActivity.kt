package com.example.denero.ambercard.View

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.denero.ambercard.R
import com.example.denero.ambercard.Server.Server
import com.example.denero.ambercard.model.RegisBody
import com.example.denero.ambercard.model.Token
import com.example.denero.ambercard.model.Views
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.id.edit



/**
 * Created by DENERO on 17.10.2017.
 */
class AuthActivity: AppCompatActivity() {
    private val server = Server()
    private val views = Views()
    private var regisBody = RegisBody()
    val TOKEN_PREF = "token"

    private var tokenR = Token()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_user)
        views.setViewsAuthActivity(this)
        views.userLogin.setText("boris")
        views.userPassword.setText("XXX666xxx")
        regisBody.username = views.userLogin.text.toString()
        regisBody.password = views.userPassword.text.toString()



    }

    fun authUser(v: View){
        val call: Call<Any> = server.req.authorizationUser(regisBody)
        call.enqueue(object:Callback<Any>{
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                Toast.makeText(applicationContext,"Auth FAIL",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
               tokenR = server.gson.fromJson(response?.body().toString(),Token::class.java)
                Toast.makeText(applicationContext,tokenR.token+"\n"+"Все прекрасно",Toast.LENGTH_LONG).show()
                saveToken(tokenR)
                Thread.sleep(1000)
                var intent=Intent(this@AuthActivity,AllPointActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }

    fun saveToken(tokenR:Token){
        var sPref  = getSharedPreferences("Token",Context.MODE_APPEND)
        var ed = sPref.edit()
        ed.putString(TOKEN_PREF,tokenR.token)
        ed.apply()
    }
}