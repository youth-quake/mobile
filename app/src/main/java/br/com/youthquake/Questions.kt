package br.com.youthquake

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.*
import br.com.youthquake.config.FillQuestions
import br.com.youthquake.model.Question
import kotlinx.android.synthetic.main.activity_questions.*

class Questions : AppCompatActivity() {

    private val totalQuestions = 5

    private var counter: Int = 1

    private var previousQuestion: Question? = null
    private var currentQuestion: Question? = null

    private var countTotal: Int = 5

    private var wrong: Int = 0
    private var right: Int = 0

    private val delayAfterCheckPoints = Handler()
    private val animation = AlphaAnimation(0.2f, 1.0f)

    var idUser:Long = 0
    var level:Int = 0
    var picture:Int = 0
    var score:Int = 0
    var name:String = ""
    var scoreOnQuizz:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        level = intent.getIntExtra("level", 1)
        idUser = intent.getLongExtra("idUser", 0)
        picture = intent.getIntExtra("picture", R.mipmap.dracula)
        score = intent.getIntExtra("score", 0)
        name = intent.getStringExtra("name")

        imgArrow.setOnClickListener{
            goTo(Intent(this, Home::class.java))
        }

        txtCountQuestions.text = "Questão $counter/$countTotal"

        currentQuestion = fillQuestion()
        showQuestion()

        if(answerIsChecked()) checkPoints()

        submitButton.setOnClickListener {

            animation.duration = 1000
            it.startAnimation(animation)

            if(!answerIsChecked()){
                Toast.makeText(this, "Você precisa selecionar uma opção", Toast.LENGTH_SHORT).show()
            }else{
                checkPoints()
                delayAfterCheckPoints.postDelayed({ showQuestion() }, 1000)
            }
        }
    }

    private fun fillQuestion(): Question? {
        val fillQuestion = FillQuestions()
        val modelQuestion:Question? = fillQuestion.execute((0..8).shuffled().last().toInt()).get()

        modelQuestion?.idQuestion
        modelQuestion?.question
        modelQuestion?.firstOption
        modelQuestion?.secondOption
        modelQuestion?.thirdOption
        modelQuestion?.fourthOption
        modelQuestion?.rightAnswer

        return modelQuestion
    }

    private fun showQuestion() {
        if (counter <= countTotal) {

            if(counter === countTotal){
                submitButton.text = "Finalizar"
            }

            radioGroup!!.clearCheck()

            radioButton1.setTextColor(Color.BLACK)
            radioButton2.setTextColor(Color.BLACK)
            radioButton3.setTextColor(Color.BLACK)
            radioButton4.setTextColor(Color.BLACK)

            currentQuestion = fillQuestion()

            while(currentQuestion?.question.isNullOrBlank() || currentQuestion?.question === previousQuestion?.question){
                currentQuestion = fillQuestion()
            }

            question.text = currentQuestion?.question
            radioButton1.text = currentQuestion?.firstOption
            radioButton2.text = currentQuestion?.secondOption
            radioButton3.text = currentQuestion?.thirdOption
            radioButton4.text = currentQuestion?.fourthOption

            txtCountQuestions.text = "Questão: $counter/$countTotal"
            counter++

        } else {
            goTo(Intent(this, FeedbackQuizz::class.java))
        }
    }

    private fun checkPoints(){
        val radioSelected = findViewById<View>(radioGroup.checkedRadioButtonId) as RadioButton
        val answer = radioSelected.text.toString()

        if (answer == currentQuestion?.rightAnswer) {
            radioSelected.setTextColor(getColor(R.color.colorPrimaryDark))
            scoreOnQuizz++
            right++
        }else{
            radioSelected.setTextColor(getColor(R.color.colorWrong))
            wrong++
        }

        previousQuestion = currentQuestion
    }

    private fun answerIsChecked():Boolean {
       if(radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked()){
           return true
       }

        return false
    }

    private fun goTo(activity:Intent){
        activity.putExtra("name", name)
        activity.putExtra("picture",picture)
        activity.putExtra("idUser", idUser)
        activity.putExtra("score", score)
        activity.putExtra("level", level)
        activity.putExtra("right", right)
        activity.putExtra("wrong", wrong)
        activity.putExtra("scoreOnQuizz", scoreOnQuizz)

        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }
}
