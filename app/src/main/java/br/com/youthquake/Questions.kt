package br.com.youthquake

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.*
import androidx.core.util.toRange
import br.com.youthquake.config.FillQuestions
import br.com.youthquake.model.Question
import kotlinx.android.synthetic.main.activity_questions.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

class Questions : AppCompatActivity() {


    private var counter: Int = 1
    private var currentQuestion: Question? = null
    private var countTotal: Int = 5

    private var score: Int = 0
    private var answered: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        txtCountQuestions.text = "Questão $counter/$countTotal"
        currentQuestion = fillQuestion()


        submitButton!!.setOnClickListener {
            if (!answered) {
                if (radioButton1!!.isChecked || radioButton2!!.isChecked || radioButton3!!.isChecked || radioButton4!!.isChecked)
                    check()
                else
                    Toast.makeText(this@Questions, "Opa! Você precisa selcionar uma opção", Toast.LENGTH_SHORT).show()
            } else {
                showQuestion()
            }
        }
    }

    var totalQuestions = 10

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

        answered = false
        radioGroup!!.clearCheck()

        if (counter < countTotal) {
            currentQuestion = fillQuestion()

            question.text = currentQuestion?.question
            radioButton1.text = currentQuestion?.firstOption
            radioButton2.text = currentQuestion?.secondOption
            radioButton3.text = currentQuestion?.thirdOption
            radioButton4.text = currentQuestion?.fourthOption

            txtCountQuestions.text = "Questão: $counter/$countTotal"

            counter++

            if(radioButton1!!.isChecked || radioButton2!!.isChecked || radioButton3!!.isChecked || radioButton4!!.isChecked){
                check()
            }

            submitButton.text = "Avançar"
        } else {
            submitButton.text = "Finalizar"
            finishQuizActivity()
        }
    }

    private fun check() {

        answered = true

        val radioSelected = findViewById<View>(radioGroup!!.checkedRadioButtonId) as RadioButton
        val answer = radioSelected.text

        if (answer == currentQuestion?.rightAnswer) {
            radioSelected.setTextColor(Color.GREEN)
            score++
        }

    }

    private fun finishQuizActivity() {
        Intent().putExtra("finalScore", score)
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

