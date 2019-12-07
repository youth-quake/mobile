package br.com.youthquake

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
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

    private var score: Int = 0
    private var wrong: Int = 0
    private var right: Int = 0

    private val delayAfterCheckPoints = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        txtCountQuestions.text = "Questão $counter/$countTotal"

        currentQuestion = fillQuestion()
        showQuestion()

        if(answerIsChecked()) checkPoints()

        submitButton.setOnClickListener {
            if(!answerIsChecked()){
                Toast.makeText(this, "Você precisa selecionar uma opção", Toast.LENGTH_SHORT).show()
            }else{
                checkPoints()
                delayAfterCheckPoints.postDelayed({ showQuestion() }, 1000)
            }
        }

        imgArrow.setOnClickListener{
            val actHome = Intent(this, Home::class.java)
            actHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actHome)
        }
    }

    private fun fillQuestion(): Question? {
        val fillQuestion = FillQuestions()
        val modelQuestion:Question? = fillQuestion.execute((0..totalQuestions).shuffled().last().toInt()).get()

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

            while(currentQuestion?.question.isNullOrBlank()){
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
            val actResult = Intent(this, FeedbackQuizz::class.java)
            actResult.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

            actResult.putExtra("score", score)
            actResult.putExtra("wrong", wrong)
            actResult.putExtra("right", right)

            startActivity(actResult)
        }
    }

    private fun checkPoints(){
        val radioSelected = findViewById<View>(radioGroup.checkedRadioButtonId) as RadioButton
        val answer = radioSelected.text.toString()

        if (answer == currentQuestion?.rightAnswer) {
            radioSelected.setTextColor(Color.GREEN)
            score++
            right++
        }else{
            radioSelected.setTextColor(Color.RED)
            wrong++
        }
    }

    private fun answerIsChecked():Boolean {
       if(radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked()){
           return true
       }

        return false
    }

    var lastBack:Long = 0L

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastBack > 2000) {
            Toast.makeText(this, getString(R.string.pressBackToFinish), Toast.LENGTH_SHORT).show()
            lastBack = System.currentTimeMillis()
        }
        else {
            val goHome = Intent(this, FirstSteps::class.java)
            goHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(goHome)
        }
    }
}
