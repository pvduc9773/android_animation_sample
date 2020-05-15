package com.pvduc9773.animationdemo

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_shared.*


class SharedActivity : AppCompatActivity() {

    companion object {
        const val BUTTON = "image"
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        ViewCompat.setTransitionName(btBack, BUTTON)

        btBack.setOnClickListener {
            onBackPressed()
        }

        btDrawble.setOnClickListener {
            val drawable: Drawable = ivSharedView.drawable
            if (drawable.alpha == 0) {
                val animator = ObjectAnimator.ofPropertyValuesHolder(
                    drawable,
                    PropertyValuesHolder.ofInt("alpha", 255)
                )
                animator.target = drawable
                animator.duration = 1000
                animator.start()
            } else {
                val animator = ObjectAnimator.ofPropertyValuesHolder(
                    drawable,
                    PropertyValuesHolder.ofInt("alpha", 0)
                )
                animator.target = drawable
                animator.duration = 1000
                animator.start()
            }

        }
    }

}
