package br.com.youthquake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.youthquake.config.FillFriends
import br.com.youthquake.config.FillQuestions
import br.com.youthquake.config.UserAuthenticate
import br.com.youthquake.model.Friends
import br.com.youthquake.model.Question
import br.com.youthquake.model.User
import kotlinx.android.synthetic.main.activity_friends.*
import kotlinx.android.synthetic.main.activity_login.*

class Ranking : AppCompatActivity() {

    private val totalFriends = 10
    private var friend: Friends? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        imgArrow.setOnClickListener{
            val actHome = Intent(this, Home::class.java)
            actHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(actHome)
        }

        showFriends()
    }

    private fun fillFriends(): Friends? {
        val fillFriends = FillFriends()
        val modelFriends: Friends? = fillFriends.execute((0..totalFriends).shuffled().last().toInt()).get()

        modelFriends?.user1
        modelFriends?.user2

        return modelFriends
    }

    private fun showFriends(){
        friend = fillFriends()

        name.text = friend?.user1?.name
        tvLevel.text = friend?.user1?.level.toString()
        tvCoin.text = friend?.user1?.score.toString()
    }

}
