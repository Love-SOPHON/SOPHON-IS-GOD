package redstone.god1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread {
            while (true) {
                text.setTextColor(
                    android.graphics.Color.rgb(
                        (0..255).random(),
                        (0..255).random(),
                        (0..255).random()
                    )
                )
                val scale = ScaleAnimation(
                    (3..10).random().toFloat() / 10,
                    (3..20).random().toFloat() / 10,
                    (3..10).random().toFloat() / 10,
                    (2..20).random().toFloat() / 10,
                    text.width.toFloat() / 2,
                    text.height.toFloat() / 2
                )
                scale.fillAfter = true
                scale.duration = 200

                val rotate = RotateAnimation(
                    (0..359).random().toFloat(),
                    (0..359).random().toFloat(),
                    text.width.toFloat() / 2,
                    text.height.toFloat() / 2
                )
                rotate.fillAfter = true
                rotate.duration = 200

                val aS = AnimationSet(true)
                aS.addAnimation(rotate)
                aS.addAnimation(scale)

                text.startAnimation(aS)
                Thread.sleep(300)
            }
        }.start()
    }
}
