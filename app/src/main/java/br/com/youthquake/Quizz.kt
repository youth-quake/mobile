package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_quizz.*

class Quizz : AppCompatActivity() {

    var idUser:Long = 0
    var level:Int = 0
    var picture:Int = 0
    var score:Int = 0
    private var name:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        level = intent.getIntExtra("level", 1)
        idUser = intent.getLongExtra("idUser", 0)
        picture = intent.getIntExtra("picture", R.mipmap.dracula)
        score = intent.getIntExtra("score", 0)
        name = intent.getStringExtra("name")

        imgBack.setOnClickListener{
            goTo(Intent(this, Home::class.java))
        }

        startButton.setOnClickListener {

            val animation = AlphaAnimation(0.2f, 1.0f)
            animation.duration = 1000

            it.startAnimation(animation)

            val actQuestions = Intent(this, Questions::class.java)
            actQuestions.putExtra("idUser", idUser)
            actQuestions.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actQuestions)
        }
    }

    private fun goTo(activity:Intent){
        activity.putExtra("name", name)
        activity.putExtra("picture",picture)
        activity.putExtra("idUser", idUser)
        activity.putExtra("score", score)
        activity.putExtra("level", level)
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }
}
