package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_firststeps.*

class FirstSteps : AppCompatActivity() {

    var lastBack:Long = 0L
    var step :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firststeps)

        val name = intent.getStringExtra("name")

        img.setImageDrawable(getDrawable(R.mipmap.cartao))
        lbTitle.text = getString(R.string.titleStep1, name)
        lbSubTitle.text = getString(R.string.subTitleStep1)
        btNext.text = getString(R.string.btStepNext)

        btNext.setOnClickListener{
            when(step) {
                1 -> {
                    img.setImageDrawable(getDrawable(R.mipmap.friends))
                    lbTitle.text = getString(R.string.titleStep2)
                    lbSubTitle.text = getString(R.string.subTitleStep1)
                }
                2 -> {
                    img.setImageDrawable(getDrawable(R.mipmap.openbook))
                    lbTitle.text = getString(R.string.titleStep3)
                    lbSubTitle.text = getString(R.string.subTitleStep1)
                    btNext.text = getString(R.string.buttonUnderstand)

                    val home = Intent(this, Home::class.java)
                    home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

                    home.putExtra("idUser", intent.getLongExtra("idUser", 0))
                    home.putExtra("name",  name)
                    home.putExtra("login", intent.getStringExtra("login"))
                    home.putExtra("email", intent.getStringExtra("email"))
                    home.putExtra("password", intent.getStringExtra("password"))
                    home.putExtra("messageStatus", intent.getStringExtra("messageStatus"))
                    home.putExtra("level", intent.getIntExtra("level", 0))

                    startActivity(home)
                }
                else -> {}
            }

            step++
        }

        imgArrow.setOnClickListener {
            val backMain = Intent(this, MainActivity::class.java)
            backMain.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(backMain)
        }
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastBack > 2000) {
            Toast.makeText(this, R.string.pressBackToFinish, Toast.LENGTH_SHORT).show()
            lastBack = System.currentTimeMillis()
        }
        else finishAffinity()
    }
}
