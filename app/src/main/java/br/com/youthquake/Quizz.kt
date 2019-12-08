package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quizz.*

class Quizz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        val idUser = intent.getLongExtra("idUser", 0)

        startButton.setOnClickListener {
            val actQuestions = Intent(this, Questions::class.java)
            actQuestions.putExtra("idUser", idUser)
            actQuestions.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actQuestions)
        }
    }
}
