package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_friends.*

class Friends : AppCompatActivity() {

    var idUser:Long = 0
    var level:Int = 0
    var picture:Int = 0
    var score:Int = 0
    var name:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        level = intent.getIntExtra("level", 1)
        idUser = intent.getLongExtra("idUser", 0)
        picture = intent.getIntExtra("picture", R.mipmap.dracula)
        score = intent.getIntExtra("score", 0)
        name = intent.getStringExtra("name")

        imgArrow.setOnClickListener{
            goTo(Intent(this, Home::class.java))
        }
    }

    private fun goTo(activity:Intent){
        activity.putExtra("name",name)
        activity.putExtra("picture",picture)
        activity.putExtra("idUser", idUser)
        activity.putExtra("score", score)
        activity.putExtra("level", level)
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }
}
