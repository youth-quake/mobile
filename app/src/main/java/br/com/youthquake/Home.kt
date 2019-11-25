package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import com.squareup.picasso.Picasso

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tvName.text = intent.getStringExtra("name")
        tvLevel.text = getString(R.string.levelUser, intent.getIntExtra("level", 0))

        var path:String? = intent.getStringExtra("picture")

        if(path == null) path = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnCnE2KZRNzHPweOgduka2zTxOxM6BLvpNgdLD6kvQhrsO3Jum&s"

        Picasso.get().load(path).into(imgPerfil)

        clQuiz.setOnClickListener{
            val actQuizz = Intent(this, Quizz::class.java)
            actQuizz.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actQuizz)
        }
    }
}

