package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_friends.*

class Friends : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        imgArrow.setOnClickListener{
            val actHome = Intent(this, Home::class.java)
            actHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actHome)
        }
    }


}
