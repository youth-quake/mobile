package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.youthquake.config.UserUpdate
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_feedback_quizz.*

class FeedbackQuizz : AppCompatActivity() {

    private val valuePerPoint = 10
    private var userUpdated: User? = null

    private var totalScore:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_quizz)

        totalScore = intent.getIntExtra("score", 0)*valuePerPoint

        tvTotalPoints.text = "SEUS PONTOS: ${totalScore}"

        tvWrongPoints.text = "${intent.getIntExtra("wrong", 0)}"
        tvRightPoints.text = "${intent.getIntExtra("right", 0)}"

        btGame.setOnClickListener{
            updateScore(Intent(this, Quizz::class.java))
        }

        btExit.setOnClickListener{
            updateScore(Intent(this, Home::class.java))
        }
    }

    private fun updateScore(activity: Intent){
        val updateScore = UserUpdate()
        val user = User()

        user.idUser = intent.getLongExtra("idUser", 0)
        user.score = totalScore

        userUpdated = updateScore.execute(user).get()

        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

        intent.removeExtra("socre")
        activity.putExtra("score", userUpdated?.score)

        startActivity(activity)
    }
}
