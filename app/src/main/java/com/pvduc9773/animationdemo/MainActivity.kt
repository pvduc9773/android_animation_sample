package com.pvduc9773.animationdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btTransition.setOnClickListener {
            val intent = Intent(this, TransitionActivity::class.java)
            startActivity(intent)
        }

        ivSharedView.setOnClickListener {
            val intent = Intent(this, SharedActivity::class.java)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair.create<View, String>(ivSharedView, "image"),
                Pair.create<View, String>(btTransition, "button")
            )
            startActivity(intent, options.toBundle())
        }
    }
}
