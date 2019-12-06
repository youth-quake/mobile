package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_feedback_quizz.*

class FeedbackQuizz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_quizz)

        val valuePerPoint = 10

        tvTotalPoints.text = "SEUS PONTOS: ${intent.getIntExtra("score", 0)*valuePerPoint}"

        tvWrongPoints.text = "${intent.getIntExtra("wrong", 0)}"
        tvRightPoints.text = "${intent.getIntExtra("right", 0)}"

        btGame.setOnClickListener{
            val quizz = Intent(this, Quizz::class.java)
            quizz.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(quizz)
        }

        btExit.setOnClickListener{
            val home = Intent(this, Home::class.java)
            home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(home)
        }
    }
}
