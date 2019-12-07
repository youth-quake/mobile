package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.youthquake.config.UserUpdate
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_feedback_quizz.*

class FeedbackQuizz : AppCompatActivity() {

    private val VALUE_PER_POINT = 10
    private var userUpdated: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_quizz)

        val updateScore = UserUpdate()
        val user = User()

        user.idUser = intent.getLongExtra("idUser", 0)
        user.score = intent.getIntExtra("score", 0)*VALUE_PER_POINT

        userUpdated = updateScore.execute(user).get()

        tvTotalPoints.text = "SEUS PONTOS: ${userUpdated?.score}"

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

            home.putExtra("score", userUpdated?.score)

            startActivity(home)
        }
    }
}
