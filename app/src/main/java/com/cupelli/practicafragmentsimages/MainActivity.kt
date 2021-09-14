package com.cupelli.practicafragmentsimages

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val KEY = "STATE_KEY" //Para instanciar del MainActivity
    private var sendImage: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendImage = savedInstanceState?.getBoolean(KEY, true) ?: true
        if (sendImage)
            supportFragmentManager.beginTransaction().add(R.id.container, MainFragment())
                .commit()
    }



    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putBoolean(KEY, false)
        }

        super.onSaveInstanceState(outState)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            replace(R.id.container, fragment)
            addToBackStack(fragment.tag)
            commit()
        }
    }

    fun playSound(sound: Int) = MediaPlayer.create(this, sound).start()
}