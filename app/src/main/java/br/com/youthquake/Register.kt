package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Toast
import br.com.youthquake.config.UserInclude
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private val animation = AlphaAnimation(0.2f, 1.0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imgBack.setOnClickListener{
            goTo(Intent(this, MainActivity::class.java))
        }

        btCadastrar.setOnClickListener{

            animation.duration = 1000
            it.startAnimation(animation)

            val user = User()
            user.name = etNome.text.toString()
            user.login = etUsername.text.toString()
            user.password = etSenha.text.toString()
            user.email = etEmail.text.toString()

            val call = UserInclude()
            call.execute(user)

            Toast.makeText(this, getString(R.string.registeredSuccessfully), Toast.LENGTH_SHORT).show()

            goTo(Intent(this, Home::class.java))
        }
    }

    private fun goTo(activity:Intent){
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }

    override fun onBackPressed() {
        goTo(Intent(this, MainActivity::class.java))
    }
}
