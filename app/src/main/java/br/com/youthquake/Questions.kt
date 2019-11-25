package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import br.com.youthquake.config.FillQuestions
import br.com.youthquake.model.Question
import kotlinx.android.synthetic.main.activity_questions.*

class Questions : AppCompatActivity() {

    private var counter: Int = 0
    private var currentQuestion: Question? = null
    private var countTotal: Int = 5

    private var score: Int = 0
    private var answer: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        txtCountQuestions.text = "Questão $counter/$countTotal"
        currentQuestion = fillQuestion()

        submitButton!!.setOnClickListener {
            if (!answer) {
                if (radioButton1!!.isChecked || radioButton2!!.isChecked || radioButton3!!.isChecked || radioButton4!!.isChecked)
                    check()
                else
                    Toast.makeText(this@Questions, "Opa! Você precisa selcionar uma opção", Toast.LENGTH_SHORT).show()
            } else {
                showQuestion()
            }
        }
    }

    private fun fillQuestion(): Question? {
        val task = FillQuestions()
        val modelQuestion:Question = task.execute(1).get()

        return Question(
            modelQuestion.idQuestion,
            modelQuestion.question,
            modelQuestion.firstOption,
            modelQuestion.secondOption,
            modelQuestion.thirdOption,
            modelQuestion.fourthOption,
            modelQuestion.rightAnswer
        )
    }

    private fun showQuestion() {

        radioGroup!!.clearCheck()

        if (counter < countTotal) {
            currentQuestion = fillQuestion()

            question.text = currentQuestion?.question
            radioButton1.text = currentQuestion?.firstOption
            radioButton2.text = currentQuestion?.secondOption
            radioButton3.text = currentQuestion?.thirdOption
            radioButton4.text = currentQuestion?.fourthOption

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
        Toast.makeText(this@Questions, "Pressione novamente para sair", Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}
