package com.example.denero.ambercard.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.denero.ambercard.R
import com.example.denero.ambercard.Repository.Server
import com.example.denero.ambercard.model.RegisBody
import com.example.denero.ambercard.model.Token
import com.example.denero.ambercard.model.Views
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by DENERO on 17.10.2017.
 */
class AuthActivity: AppCompatActivity() {
    private val server = Server()
    private val views = Views()

    val TOKEN_PREF = "token"

    private var tokenR = Token()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_user)
        views.setViewsAuthActivity(this)
        views.userLogin.setText("boris")
        views.userPassword.setText("XXX666xxx")




    }

    fun authUser(v: View){
        var regisBody = RegisBody(views.userLogin.text.toString(),views.userPassword.text.toString())
        if(regisBody.username!=""&&regisBody.password!="")
        {
        val call: Call<Token> = server.req.authorizationUser(regisBody)
        call.enqueue(object:Callback<Token>{
            override fun onFailure(call: Call<Token>?, t: Throwable?) {
                Toast.makeText(applicationContext,"Auth FAIL",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Token>?, response: Response<Token>?) {
                tokenR = response?.body()!!
                Toast.makeText(applicationContext,tokenR.token+"\n"+"Все прекрасно",Toast.LENGTH_LONG).show()
                saveToken(tokenR)
                Thread.sleep(1000)
                var intent=Intent(this@AuthActivity,AllPointActivity::class.java)
                startActivity(intent)
                finish()
            }
        })}
    }

    fun saveToken(tokenR:Token){
        var sPref  = getSharedPreferences("Token",Context.MODE_APPEND)
        var ed = sPref.edit()
        ed.putString(TOKEN_PREF,tokenR.token)
        ed.apply()
    }
}