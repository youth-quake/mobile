package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import android.content.Context

class Home : AppCompatActivity() {

    var idUser:Long = 0
    var level:Int = 0
    var picture:Int = 0
    var score:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        level = intent.getIntExtra("level", 1)
        idUser = intent.getLongExtra("idUser", 0)
        picture = intent.getIntExtra("picture", R.mipmap.dracula)
        score = intent.getIntExtra("score", 0)

        tvName.text = intent.getStringExtra("name")
        tvLevel.text = getString(R.string.levelUser, level)
        tvCoin.text = "YQ ${intent.getIntExtra("score", 0)}"

        imgProfile.setImageResource(picture)

        imgProfile.setOnClickListener{
            goTo(Intent(this, UpdateIconsProfile::class.java))
        }

        clQuiz.setOnClickListener{
            goTo(Intent(this, Quizz::class.java))
        }

        clMeusAmigos.setOnClickListener{
            goTo(Intent(this, Ranking::class.java))
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
        activity.putExtra("idUser", idUser)
        activity.putExtra("level", level)
        activity.putExtra("score", score)
        activity.putExtra("picture", picture)
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

