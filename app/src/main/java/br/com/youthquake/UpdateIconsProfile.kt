package br.com.youthquake

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout.LayoutParams
import android.widget.Toast
import br.com.youthquake.config.UserUpdate
import br.com.youthquake.model.Icon
import br.com.youthquake.model.Icons
import br.com.youthquake.model.User
import com.github.siyamed.shapeimageview.CircularImageView
import kotlinx.android.synthetic.main.activity_friends.*
import kotlinx.android.synthetic.main.activity_friends.imgArrow
import kotlinx.android.synthetic.main.activity_update_icons_profile.*

class UpdateIconsProfile : AppCompatActivity() {

    private var userUpdated: User? = null

    private val delayAfterClickImage = Handler()

    private val marginPerComponent = 25
    private val sizeImage = 150

    var idUser:Long = 0
    var level:Int = 0
    var picture:Int = 0
    var score:Int = 0
    var name:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_icons_profile)

        level = intent.getIntExtra("level", 1)
        idUser = intent.getLongExtra("idUser", 0)
        picture = intent.getIntExtra("picture", Icons.DRACULA.icon.icon)
        score = intent.getIntExtra("score", 0)
        name = intent.getStringExtra("name")

        imgArrow.setOnClickListener{
            goTo(Intent(this, Home::class.java))
        }

        val frame = GridLayout(applicationContext)

        val ltParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        ltParams.setMargins(50,200,50,5)

        frame.layoutParams = ltParams
        frame.orientation = GridLayout.HORIZONTAL
        frame.columnCount = 3
        frame.background = getDrawable(R.color.colorPrimary)

        createFrameWithImages(arrayListOf(
            Icons.RAINBOW.icon,
            Icons.COCKATOO.icon,
            Icons.FLOAT.icon,
            Icons.BIRD.icon,
            Icons.AKALI.icon,
            Icons.ALESSANDRA.icon,
            Icons.DRACULA.icon,
            Icons.FLAMINGO.icon,
            Icons.GHOST.icon,
            Icons.GINGERBREAD.icon,
            Icons.PRIDE.icon,
            Icons.CHICK.icon,
            Icons.CAT.icon,
            Icons.SHEN.icon,
            Icons.SOCCER.icon,
            Icons.APPLE.icon,
            Icons.ACCOUSTIC.icon,
            Icons.TURTLE.icon,
            Icons.GUITAR.icon,
            Icons.GINGERBREAD.icon,
            Icons.SKELETON.icon,
            Icons.HUSKY.icon,
            Icons.PACMAN.icon,
            Icons.BASKETBALL.icon,
            Icons.BASKETPLAYER.icon,
            Icons.HUSKY.icon
        ), frame)

        scroll.addView(frame, ltParams)
    }

    private fun addImage(img:Icon) : ImageView{
        val ltParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        ltParams.width = sizeImage
        ltParams.height = sizeImage
        ltParams.setMargins(marginPerComponent, marginPerComponent-10, marginPerComponent, marginPerComponent-10)
        ltParams.gravity = Gravity.LEFT

        var image = CircularImageView(applicationContext)
        image.layoutParams = ltParams

        var pathIcon = 0

        if(score < img.necessaryPoints){
            pathIcon = img.disabledIcon

            image.setOnClickListener{
                Toast.makeText(this, "Esse ícone está bloqueado, ganhe pontos para liberar!", Toast.LENGTH_LONG).show()
            }
        }else{
            pathIcon = img.icon

            image.setOnClickListener{

                image.setBorderColor(Color.GREEN)

                val updateScore = UserUpdate()
                val user = User()

                user.idUser = intent.getLongExtra("idUser", 0)
                user.picture = pathIcon.toString()

                userUpdated = updateScore.execute(user).get()
                picture = userUpdated?.picture!!.toInt()

                delayAfterClickImage.postDelayed({ goTo(Intent(this, Home::class.java)) }, 300)
            }
        }

        image.setImageResource(pathIcon)
        image.borderWidth = 6
        image.setBorderColor(Color.TRANSPARENT)
        image.id = img.id

        return image
    }

    private fun createFrameWithImages(totalImagesWithPaths:ArrayList<Icon>, frame:GridLayout):GridLayout {
        totalImagesWithPaths.forEach{img ->
            frame.addView(addImage(img))
        }

        return  frame
    }

    private fun goTo(activity: Intent){
        activity.putExtra("name", name)
        activity.putExtra("level",level)
        activity.putExtra("score", score)
        activity.putExtra("idUser", idUser)
        activity.putExtra("picture", picture)
        activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(activity)
    }
}
