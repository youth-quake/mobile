package br.com.youthquake

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val idUser = intent.getLongExtra("idUser", 0)
        val nameUser = intent.getStringExtra("name")
        val login = intent.getStringExtra("login")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val messageStatus = intent.getStringExtra("messageStatus")
        val levelUser = intent.getIntExtra("level", 0)

        imgArrowHome.setOnClickListener {
             val backMain = Intent(this, MainActivity::class.java)
             startActivity(backMain)
        }

        imgArrowExit.setOnClickListener {
            val backMain = Intent(this, MainActivity::class.java)
            startActivity(backMain)
        }

        imgArrowFriends.setOnClickListener {
            val goFriends = Intent(this, Friends::class.java)
            goFriends.putExtra("idUser", idUser)
            goFriends.putExtra("name",  nameUser)
            goFriends.putExtra("login", login)
            goFriends.putExtra("email", email)
            goFriends.putExtra("password", password)
            goFriends.putExtra("messageStatus", messageStatus)
            goFriends.putExtra("level", levelUser)
            startActivity(goFriends)
        }

        name.text = nameUser
        level.text = getString(R.string.level, levelUser)
    }
}

