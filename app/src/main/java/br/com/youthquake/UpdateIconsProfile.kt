package br.com.youthquake

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams

class UpdateIconsProfile : AppCompatActivity() {

    private val maxWidth = 660
    private val marginPerComponent = 10
    private val sizeImage = 190

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_icons_profile)

       val frame = addMainFrame()

        frame.addView(createFrameWithImages(
            R.mipmap.chick,
            R.mipmap.alessandra,
            R.mipmap.akali
        ))

        frame.addView(createFrameWithImages(
            R.mipmap.acoustic,
            R.mipmap.apple,
            R.mipmap.bird
        ))

        frame.addView(createFrameWithImages(
            R.mipmap.pride,
            R.mipmap.cat,
            R.mipmap.soccer
        ))

        frame.addView(createFrameWithImages(
            R.mipmap.skeleton,
            R.mipmap.rainbow,
            R.mipmap.siberianhusky
        ))

        frame.addView(createFrameWithImages(
            R.mipmap.flamingo,
            R.mipmap.volpe,
            R.mipmap.dracula
        ))

        val lastImages = addFrame()

        lastImages.addView(addImage(R.mipmap.pacman))
        lastImages.addView(addImage(R.mipmap.gingerbread))

        frame.addView(lastImages)

        setContentView(frame)
    }

    private fun addMainFrame():LinearLayout {
        val ltParamsParent = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        ltParamsParent.width = maxWidth
        ltParamsParent.setMargins(marginPerComponent,marginPerComponent,marginPerComponent,marginPerComponent)

        val frame = LinearLayout(applicationContext)
        frame.layoutParams = ltParamsParent
        frame.orientation = LinearLayout.VERTICAL

        return frame
    }

    private fun addFrame():LinearLayout{
        val ltParamsParent = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        ltParamsParent.width = 660
        ltParamsParent.setMargins(10,20,10,20)

        val frame = LinearLayout(applicationContext)
        frame.layoutParams = ltParamsParent

        return  frame
    }

    private fun addImage(pathImage:Int) : ImageView{
        val ltParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        ltParams.width = sizeImage
        ltParams.height = sizeImage
        ltParams.setMargins(marginPerComponent, 0, marginPerComponent, 5)

        var image = ImageView(applicationContext)

        image.layoutParams = ltParams
        image.setImageResource(pathImage)

        return image
    }

    private fun createFrameWithImages(stPathImage:Int, ndPathImage:Int, rdPathImage:Int):LinearLayout {

        val ltParamsParent = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        ltParamsParent.width = maxWidth
        ltParamsParent.setMargins(marginPerComponent,20,marginPerComponent,20)

        val frame = LinearLayout(applicationContext)
        frame.layoutParams = ltParamsParent

        val ltParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        ltParams.width = 190
        ltParams.height = 190
        ltParams.setMargins(marginPerComponent, 0, marginPerComponent, 5)

        var stImage = ImageView(applicationContext)
        stImage.layoutParams = ltParams
        stImage.setImageResource(stPathImage)
        frame.addView(stImage)

        var ndImage = ImageView(applicationContext)
        ndImage.layoutParams = ltParams
        ndImage.setImageResource(ndPathImage)
        frame.addView(ndImage)

        var rdImage = ImageView(applicationContext)
        rdImage.layoutParams = ltParams
        rdImage.setImageResource(rdPathImage)
        frame.addView(rdImage)

        return  frame
    }


}
