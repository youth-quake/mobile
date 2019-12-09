package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_quizz.*

class Quizz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        val idUser = intent.getLongExtra("idUser", 0)

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
}
