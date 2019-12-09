package br.com.youthquake

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import br.com.youthquake.config.UserAuthenticate
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_login.*
import android.view.animation.AlphaAnimation

class Login : AppCompatActivity() {

    private var preferences : SharedPreferences? = null
    private var editPreferences : SharedPreferences.Editor? = null

    private val animation = AlphaAnimation(0.2f, 1.0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        imgBack.setOnClickListener{
            goTo(Intent(this, MainActivity::class.java))
        }

        preferences = getSharedPreferences("app-alert", Context.MODE_PRIVATE)
        editPreferences = preferences?.edit()

        if (preferences!!.getBoolean("remember", false)) {
            enableAccess(
                preferences?.getLong("idUser", 0),
                preferences?.getString("name", "Youthquake"),
                preferences?.getString("login", "youth"),
                preferences?.getString("email", "youthquake@youthquake.com"),
                preferences?.getString("password", "123"),
                preferences?.getString("messageStatus", "Construindo um futuro melhor"),
                preferences?.getInt("level", 1),
                preferences?.getInt("picture", R.mipmap.volpe),
                preferences?.getInt("score", 1),
                preferences?.getInt("firstAccess", 1)
            )
        }

        btLogin.setOnClickListener{

            animation.duration = 1000
            it.startAnimation(animation)

            val user = User()
            user.login = etUsername.text.toString()
            user.password = etPassword.text.toString()

            val call = UserAuthenticate()
            val response: User? = call.execute(user).get()

            if(response != null){

                if(remember.isChecked){
                    editPreferences?.putBoolean("remember", true)
                    editPreferences?.putLong("idUser", response.idUser!!)
                    editPreferences?.putString("name", response.name)
                    editPreferences?.putString("login", response.login)
                    editPreferences?.putString("email", response.email)
                    editPreferences?.putString("password", response.password)
                    editPreferences?.putString("messageStatus", response.messageStatus)
                    editPreferences?.putInt("level", response.level!!)
                    editPreferences?.putInt("picture", response.picture!!.toInt())
                    editPreferences?.putInt("score", response.score!!)
                    editPreferences?.putInt("firstAccess", response.firstAcess!!)
                    editPreferences?.commit()
                }

                enableAccess(
                    response.idUser,
                    response.name,
                    response.login,
                    response.email,
                    response.password,
                    response.messageStatus,
                    response.level,
                    response.picture!!.toInt(),
                    response.score,
                    response.firstAcess
                )
            } else {
                rejectedAccess()
            }
        }
    }

    private fun enableAccess(
        idUser:Long?,
        name:String?,
        login:String?,
        email:String?,
        password:String?,
        messageStatus:String?,
        level:Int?,
        picture:Int?,
        score:Int?,
        firstAccess:Int?
    ){
        val intent = if(firstAccess === 0){
            Intent(this, Home::class.java)
        }else{
            Intent(this, FirstSteps::class.java)
        }

        clearData()

        intent.putExtra("idUser", idUser)
        intent.putExtra("name",  name)
        intent.putExtra("login", login)
        intent.putExtra("email", email)
        intent.putExtra("password", password)
        intent.putExtra("messageStatus", messageStatus)
        intent.putExtra("level", level)
        intent.putExtra("picture", picture!!.toInt())
        intent.putExtra("score", score)

        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

        startActivity(intent)
    }

    private fun rejectedAccess(){
        Toast.makeText(this, getString(R.string.rejectedAccess), Toast.LENGTH_LONG).show()
    }

    private fun goTo(activity:Intent){
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }

    override fun onBackPressed() {
        goTo(Intent(this, MainActivity::class.java))
    }

    private fun clearData(){
        val settings = getSharedPreferences("app-alert", Context.MODE_PRIVATE)
        settings.edit().clear().commit()

        intent.removeExtra("idUser")
        intent.removeExtra("level")
        intent.removeExtra("name")
        intent.removeExtra("login")
        intent.removeExtra("email")
        intent.removeExtra("password")
        intent.removeExtra("score")
        intent.removeExtra("messageStatus")
    }
}
