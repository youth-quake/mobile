package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_firststeps.*

class FirstSteps : AppCompatActivity() {

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
                    lbSubTitle.text = getString(R.string.subTitleStep2)

                    imgStStep.setImageResource(R.mipmap.`in`)
                    imgNdStep.setImageResource(R.mipmap.out)
                    imgRdStep.setImageResource(R.mipmap.out)
                }
                2 -> {
                    img.setImageDrawable(getDrawable(R.mipmap.openbook))
                    lbTitle.text = getString(R.string.titleStep3)
                    lbSubTitle.text = getString(R.string.subTitleStep3)
                    btNext.text = getString(R.string.buttonUnderstand)

                    imgStStep.setImageResource(R.mipmap.out)
                    imgNdStep.setImageResource(R.mipmap.`in`)
                    imgRdStep.setImageResource(R.mipmap.out)
                }
                3 -> {
                    val home = Intent(this, Home::class.java)
                    home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

                    home.putExtra("idUser", intent.getLongExtra("idUser", 0))
                    home.putExtra("name",  name)
                    home.putExtra("login", intent.getStringExtra("login"))
                    home.putExtra("email", intent.getStringExtra("email"))
                    home.putExtra("password", intent.getStringExtra("password"))
                    home.putExtra("messageStatus", intent.getStringExtra("messageStatus"))
                    home.putExtra("level", intent.getIntExtra("level", 0))

                    imgStStep.setImageResource(R.mipmap.out)
                    imgNdStep.setImageResource(R.mipmap.out)
                    imgRdStep.setImageResource(R.mipmap.`in`)

                    startActivity(home)
                }
                else -> {}
            }

            step++
        }
    }
}
