package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_friends.*

class Friends : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        val idUser = intent.getLongExtra("idUser", 0)
        val name = intent.getStringExtra("name")
        val login = intent.getStringExtra("login")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val messageStatus = intent.getStringExtra("messageStatus")
        val level = intent.getIntExtra("level", 0)

        imgArrowExitFriends.setOnClickListener {
            val backHome = Intent(this, Home::class.java)
            backHome.putExtra("idUser", idUser)
            backHome.putExtra("name",  name)
            backHome.putExtra("login", login)
            backHome.putExtra("email", email)
            backHome.putExtra("password", password)
            backHome.putExtra("messageStatus", messageStatus)
            backHome.putExtra("level", level)
            startActivity(backHome)
        }
    }
}
