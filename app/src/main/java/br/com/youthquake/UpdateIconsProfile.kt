package br.com.youthquake

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout.LayoutParams
import br.com.youthquake.config.UserUpdate
import br.com.youthquake.model.User
import com.github.siyamed.shapeimageview.CircularImageView

class UpdateIconsProfile : AppCompatActivity() {

    private var userUpdated: User? = null

    private val delayAfterClickImage = Handler()

    private val marginPerComponent = 25
    private val sizeImage = 150

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_icons_profile)

        val frame = GridLayout(applicationContext)

        val ltParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        ltParams.setMargins(50,200,50,0)

        frame.layoutParams = ltParams
        frame.orientation = GridLayout.HORIZONTAL
        frame.columnCount = 3
        frame.background = getDrawable(R.color.colorPrimary)

        createFrameWithImages(
            arrayListOf(
                R.mipmap.skeleton,
                R.mipmap.rainbow,
                R.mipmap.cockatoo,
                R.mipmap.volpe,
                R.mipmap.bird,
                R.mipmap.akali,
                R.mipmap.alessandra,
                R.mipmap.dracula,
                R.mipmap.flamingo,
                R.mipmap.ghost,
                R.mipmap.gingerbread,
                R.mipmap.pride,
                R.mipmap.chick,
                R.mipmap.cat,
                R.mipmap.shen,
                R.mipmap.soccer,
                R.mipmap.apple,
                R.mipmap.acoustic,
                R.mipmap.turtle
            ), frame)

        addContentView(frame, ltParams)
    }

    private fun addImage(pathImage:Int, id:Int) : ImageView{
        val ltParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        ltParams.width = sizeImage
        ltParams.height = sizeImage
        ltParams.setMargins(marginPerComponent, marginPerComponent-10, marginPerComponent, marginPerComponent-10)
        ltParams.gravity = Gravity.LEFT

        var image = CircularImageView(applicationContext)
        image.layoutParams = ltParams
        image.setImageResource(pathImage)
        image.borderWidth = 6
        image.setBorderColor(Color.TRANSPARENT)
        image.id = id

        image.setOnClickListener{

            image.setBorderColor(Color.GREEN)

            val updateScore = UserUpdate()
            val user = User()

            user.idUser = intent.getLongExtra("idUser", 0)
            user.picture = pathImage.toString()

            userUpdated = updateScore.execute(user).get()

            delayAfterClickImage.postDelayed({ goTo(Intent(this, Home::class.java)) }, 300)
        }

        return image
    }

    private fun createFrameWithImages(totalImagesWithPaths:ArrayList<Int>, frame:GridLayout):GridLayout {

        val ltParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        ltParams.width = sizeImage
        ltParams.height = sizeImage

        var id = 0

        totalImagesWithPaths.forEach{img ->
            frame.addView(addImage(img, id))
            id++
        }

        return  frame
    }

    private fun goTo(activity: Intent){
        activity.putExtra("level", userUpdated?.level)
        activity.putExtra("score", userUpdated?.score)
        activity.putExtra("idUser", userUpdated?.idUser)
        activity.putExtra("picture", userUpdated?.picture!!.toInt())
        activity.putExtra("idUser", userUpdated?.idUser)
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }
}
