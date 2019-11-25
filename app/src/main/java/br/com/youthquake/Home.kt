package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        clQuiz.setOnClickListener{
            val actQuizz = Intent(this, Quizz::class.java)
            actQuizz.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actQuizz)
        }
    }
}

