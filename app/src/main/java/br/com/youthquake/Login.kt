package br.com.youthquake

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.youthquake.config.UserAuthenticate
import br.com.youthquake.model.Photos
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    var preferences : SharedPreferences? = null
    var editPreferences : SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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
                preferences?.getString("picture", "${Photos.FLOAT}")
            )
        }

        btLogin.setOnClickListener{
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
                    editPreferences?.putString("picture", response.picture)

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
                    response.picture
                )
            } else rejectedAccess()
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
        picture:String?
    ){
        val goHome = Intent(this, FirstSteps::class.java)

        goHome.putExtra("idUser", idUser)
        goHome.putExtra("name",  name)
        goHome.putExtra("login", login)
        goHome.putExtra("email", email)
        goHome.putExtra("password", password)
        goHome.putExtra("messageStatus", messageStatus)
        goHome.putExtra("level", level)
        goHome.putExtra("picture", picture)

        goHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(goHome)
    }

    private fun rejectedAccess(){
        Toast.makeText(this, getString(R.string.rejectedAccess), Toast.LENGTH_LONG).show()
    }
}
