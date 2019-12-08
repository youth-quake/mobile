package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import android.R.id.edit
import android.content.Context
import android.text.method.TextKeyListener.clear
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val level = intent.getIntExtra("level", 1)

        tvName.text = intent.getStringExtra("name")
        tvLevel.text = getString(R.string.levelUser, level)
        tvCoin.text = "YQ ${intent.getIntExtra("score", 10)*level}"

        imgProfile.setImageDrawable(getDrawable(intent.getIntExtra("pictureDraw", R.mipmap.dracula)))

        imgProfile.setOnClickListener{
            goTo(Intent(this, UpdateIconsProfile::class.java))
        }

        clQuiz.setOnClickListener{
            goTo(Intent(this, Quizz::class.java))
        }

        clMeusAmigos.setOnClickListener{
            goTo(Intent(this, Friends::class.java))
        }

        clSair.setOnClickListener{

            val settings = getSharedPreferences("app-alert", Context.MODE_PRIVATE)
            settings.edit().clear().commit()

            intent.removeExtra("idUser")
            intent.removeExtra("level")
            intent.removeExtra("name")
            intent.removeExtra("login")
            intent.removeExtra("email")
            intent.removeExtra("password")
            intent.removeExtra("messageStatus")

            goTo(Intent(this, Login::class.java))
        }
    }

    private fun goTo(activity: Intent){
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }

    var lastBack:Long = 0L

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastBack > 2000) {
            Toast.makeText(this, getString(R.string.pressBackToFinish), Toast.LENGTH_SHORT).show()
            lastBack = System.currentTimeMillis()
        }
        else {
            finishAffinity()
        }
    }
}

