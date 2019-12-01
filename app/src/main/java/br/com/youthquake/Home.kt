package br.com.youthquake

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import com.squareup.picasso.Picasso

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tvName.text = intent.getStringExtra("name")
        tvLevel.text = getString(R.string.levelUser, intent.getIntExtra("level", 0))

        imgPerfil.setImageDrawable(getDrawable(R.mipmap.chick))

        clQuiz.setOnClickListener{
            val actQuizz = Intent(this, Quizz::class.java)
            actQuizz.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actQuizz)
        }

        clMeusAmigos.setOnClickListener{
            val actMeusAmigos = Intent(this, Friends::class.java)
            actMeusAmigos.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actMeusAmigos)
        }

        clSair.setOnClickListener{
            val actLogin = Intent(this, Login::class.java)
            actLogin.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actLogin)
        }
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

