package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_firststep.*
import kotlinx.android.synthetic.main.activity_home.*

class Firststep : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firststep)

        val idUser = intent.getLongExtra("idUser", 0)
        val name = intent.getStringExtra("name")
        val login = intent.getStringExtra("login")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val messageStatus = intent.getStringExtra("messageStatus")
        val level = intent.getIntExtra("level", 0)

        val getNameUser = getString(R.string.titleStep1, name)
        lbTitleStep1.text = getNameUser

        imgArrowStep1.setOnClickListener {
            val backMain = Intent(this, MainActivity::class.java)
            backMain.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(backMain)
        }

        undersOne.setOnClickListener {
            val avancedSecondStep = Intent(this, Secondstep::class.java)
            avancedSecondStep.putExtra("idUser", idUser)
            avancedSecondStep.putExtra("name",  name)
            avancedSecondStep.putExtra("login", login)
            avancedSecondStep.putExtra("email", email)
            avancedSecondStep.putExtra("password", password)
            avancedSecondStep.putExtra("messageStatus", messageStatus)
            avancedSecondStep.putExtra("level", level)
            avancedSecondStep.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(avancedSecondStep)
        }
    }
}
