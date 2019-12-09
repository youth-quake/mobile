package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    private val animation = AlphaAnimation(0.2f, 1.0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCriarConta.setOnClickListener {

            animation.duration = 400
            it.startAnimation(animation)

            val register = Intent(this, Register::class.java)
            register.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(register)
        }
        btEntrar.setOnClickListener {
            animation.duration = 1000
            it.startAnimation(animation)

            val login = Intent(this, Login::class.java)
            login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(login)
        }
    }

}
