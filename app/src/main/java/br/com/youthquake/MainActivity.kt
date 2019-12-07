package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCriarConta.setOnClickListener {
            val register = Intent(this, Register::class.java)
            register.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(register)
        }
        btEntrar.setOnClickListener {
            val login = Intent(this, Login::class.java)
            login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(login)
        }
    }

}
