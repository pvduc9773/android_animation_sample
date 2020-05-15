package com.pvduc9773.animationdemo

import android.os.Build
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class TransitionActivity : AppCompatActivity() {
    private var currentScene = 1

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)
        val mSceneRoot: ViewGroup = this.findViewById(R.id.scene_root)
        val mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_1, this)
        val mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.scene_2, this)

        TransitionManager.go(mScene1)


        val myTransition = ChangeBounds()
        myTransition.duration = 2000L

        mSceneRoot.setOnClickListener {
            if (currentScene == 1) {
                TransitionManager.go(mScene2, myTransition)
                currentScene = 2
            } else {
                TransitionManager.go(mScene1, myTransition)
                currentScene = 1
            }
        }
    }
}
