package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import br.com.youthquake.config.FillQuestionsTask
import br.com.youthquake.model.Question
import kotlinx.android.synthetic.main.activity_main_quizz.*

class MainQuizz : AppCompatActivity() {

    private var counter: Int = 0
    private var currentQuestion: Question? = null
    private var countTotal: Int = 5

    private var score: Int = 0
    private var answer: Boolean = false

    private val task = FillQuestionsTask()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quizz)

        txtCountQuestions.text = "Questão $counter/$countTotal"
        currentQuestion = fillQuestion()

        submitButton!!.setOnClickListener {
            if (!answer) {
                if (radioButton1!!.isChecked || radioButton2!!.isChecked || radioButton3!!.isChecked || radioButton4!!.isChecked)
                    check()
                else
                    Toast.makeText(this@MainQuizz, "Opa! Você precisa selcionar uma opção", Toast.LENGTH_SHORT).show()
            } else {
                showQuestion()
            }
        }
    }

    private fun fillQuestion(): Question? {
        return Question(1, "2+2?", "1", "2", "3", "4","4")
    }

    private fun showQuestion() {

        radioGroup!!.clearCheck()

        if (counter < countTotal) {
            currentQuestion = fillQuestion()

            question.text = currentQuestion?.question
            radioButton1.text = currentQuestion?.stOption
            radioButton2.text = currentQuestion?.ndOption
            radioButton3.text = currentQuestion?.rdOption
            radioButton4.text = currentQuestion?.thOption

            counter++
            txtCountQuestions.text = "Questão: $counter/$countTotal"

            answer = false

            submitButton!!.text = "Avançar"
        } else {
            finishQuizActivity()
        }
    }

    private fun check() {
        answer = true

        val radioSelected = findViewById<View>(radioGroup!!.checkedRadioButtonId) as RadioButton
        val answer = radioSelected.text

        if (answer == currentQuestion?.rightAnswer) score++

    }

    private fun finishQuizActivity() {
        Intent().putExtra("finalScore", score)
    }

    override fun onBackPressed() {
        Toast.makeText(this@MainQuizz, "Pressione novamente para sair", Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}
