package br.com.youthquake

import android.content.Context
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import br.com.youthquake.config.UserUpdate
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_home.*
import com.squareup.picasso.Picasso

class Home : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val level = intent.getIntExtra("level", 1)

        tvName.text = intent.getStringExtra("name")
        tvLevel.text = getString(R.string.levelUser, level)
        tvCoin.text = "Y$ ${intent.getIntExtra("score", 0)*level}"

        imgPerfil.setImageDrawable(getDrawable(R.mipmap.chick))

        imgPerfil.setOnClickListener{
            goTo(Intent(this, UpdateIconsProfile::class.java))
        }

        clQuiz.setOnClickListener{
            goTo(Intent(this, Quizz::class.java))
        }

        clMeusAmigos.setOnClickListener{
            goTo(Intent(this, Friends::class.java))
        }

        clSair.setOnClickListener{
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

