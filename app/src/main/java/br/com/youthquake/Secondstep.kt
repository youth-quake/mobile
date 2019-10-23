package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_secondstep.*

class Secondstep : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondstep)

        val idUser = intent.getLongExtra("idUser", 0)
        val name = intent.getStringExtra("name")
        val login = intent.getStringExtra("login")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val messageStatus = intent.getStringExtra("messageStatus")
        val level = intent.getIntExtra("level", 0)

        imgArrowStep2.setOnClickListener {
            val backStep1 = Intent(this, Firststep::class.java)
            backStep1.putExtra("idUser", idUser)
            backStep1.putExtra("name",  name)
            backStep1.putExtra("login", login)
            backStep1.putExtra("email", email)
            backStep1.putExtra("password", password)
            backStep1.putExtra("messageStatus", messageStatus)
            backStep1.putExtra("level", level)
            startActivity(backStep1)
        }

        undersTwo.setOnClickListener {
            val avancedThirtStep = Intent(this, Thirtstep::class.java)
            avancedThirtStep.putExtra("idUser", idUser)
            avancedThirtStep.putExtra("name",  name)
            avancedThirtStep.putExtra("login", login)
            avancedThirtStep.putExtra("email", email)
            avancedThirtStep.putExtra("password", password)
            avancedThirtStep.putExtra("messageStatus", messageStatus)
            avancedThirtStep.putExtra("level", level)
            startActivity(avancedThirtStep)
        }
    }
}
