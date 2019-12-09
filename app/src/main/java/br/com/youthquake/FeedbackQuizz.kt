package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import br.com.youthquake.config.UserUpdate
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_feedback_quizz.*

class FeedbackQuizz : AppCompatActivity() {

    private val valuePerPoint = 10
    private var userUpdated: User? = null

    private var totalScore:Int = 0
    private var idUser:Long = 0

    private val animation = AlphaAnimation(0.2f, 1.0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_quizz)

        animation.duration = 400

        idUser = intent.getLongExtra("idUser", 0)
        totalScore = intent.getIntExtra("score", 0)*valuePerPoint

        tvTotalPoints.text = "PONTOS GANHOS: ${totalScore}"

        tvWrongPoints.text = "${intent.getIntExtra("wrong", 0)}"
        tvRightPoints.text = "${intent.getIntExtra("right", 0)}"

        if(totalScore <= 2){
            tvCongratulations.text = "Você está no caminho, mas precisa estudar mais!"
        }else{
            "Parabéns! Você está indo muito bem nos estudos!"
        }

        btGame.setOnClickListener{
            it.animation = animation
            updateScore(Intent(this, Quizz::class.java))
        }

        btExit.setOnClickListener{
            it.animation = animation
            updateScore(Intent(this, Home::class.java))
        }
    }

    private fun updateScore(activity: Intent){
        val updateScore = UserUpdate()
        val user = User()

        user.idUser = idUser
        user.score = totalScore

        userUpdated = updateScore.execute(user).get()

        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

        activity.putExtra("name", userUpdated?.level)
        activity.putExtra("score", userUpdated?.score)
        activity.putExtra("idUser", userUpdated?.idUser)
        activity.putExtra("picture", userUpdated?.picture!!.toInt())
        activity.putExtra("idUser", userUpdated?.idUser)
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

        startActivity(activity)
    }
}
