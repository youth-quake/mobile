package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_thirtstep.*

class Thirtstep : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thirtstep)

        val idUser = intent.getLongExtra("idUser", 0)
        val name = intent.getStringExtra("name")
        val login = intent.getStringExtra("login")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val messageStatus = intent.getStringExtra("messageStatus")
        val level = intent.getIntExtra("level", 0)

        imgArrowStep3.setOnClickListener {
            val backStep2 = Intent(this, Secondstep::class.java)
            backStep2.putExtra("idUser", idUser)
            backStep2.putExtra("name",  name)
            backStep2.putExtra("login", login)
            backStep2.putExtra("email", email)
            backStep2.putExtra("password", password)
            backStep2.putExtra("messageStatus", messageStatus)
            backStep2.putExtra("level", level)
            startActivity(backStep2)
        }

        undersThree.setOnClickListener {
            val avancedHome = Intent(this, Home::class.java)
            avancedHome.putExtra("idUser", idUser)
            avancedHome.putExtra("name",  name)
            avancedHome.putExtra("login", login)
            avancedHome.putExtra("email", email)
            avancedHome.putExtra("password", password)
            avancedHome.putExtra("messageStatus", messageStatus)
            avancedHome.putExtra("level", level)
            startActivity(avancedHome)
        }
    }
}
