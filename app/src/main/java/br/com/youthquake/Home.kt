package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imgArrow.setOnClickListener {
            val backMain = Intent(this, MainActivity::class.java)
            startActivity(backMain)
        }

        name.text = intent.getStringExtra("name")
        level.text = intent.getIntExtra("level", 0).toString()
    }
}

