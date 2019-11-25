package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import com.squareup.picasso.Picasso

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tvName.text = intent.getStringExtra("name")
        tvLevel.text = getString(R.string.levelUser, intent.getIntExtra("level", 0))

        var path:String? = intent.getStringExtra("picture")

        if(path == null) path = "https://picturesyouthquake.file.core.windows.net/photos/profile-icons/float.png?st=2019-11-25T18%3A31%3A46Z&se=2020-11-26T18%3A31%3A00Z&sp=rl&sv=2018-03-28&sr=f&sig=1mw81OSU9JfTMPjS%2BRDghaE6bzElKRoSmMSMk0aKAIA%3D"

        Picasso.get().load(path).into(imgPerfil)

        clQuiz.setOnClickListener{
            val actQuizz = Intent(this, Quizz::class.java)
            actQuizz.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actQuizz)
        }
    }

    var lastBack:Long = 0L

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastBack > 2000) {
            Toast.makeText(this, getString(R.string.pressBackToFinish), Toast.LENGTH_SHORT).show()
            lastBack = System.currentTimeMillis()
        }
        else {
            finishAndRemoveTask()
        }
    }
}

