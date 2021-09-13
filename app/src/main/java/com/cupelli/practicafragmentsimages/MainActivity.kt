package com.cupelli.practicafragmentsimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // supportFragmentManager.beginTransaction().add(R.id.container)

        findViewById<Button>(R.id.btnInfo).setOnClickListener{
            replaceFragment(middleFragment().apply {
                arguments = Bundle().apply {
                    putString("Key","C'est le fragment middle")
                }
            })
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            //TODO: Servirá para agregar animaciones al cambio de vista
            /*setCustomAnimations(
                R.anim.anim_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )*/

            replace(R.id.container, fragment)
            addToBackStack(fragment.tag) //Regresa al estado anterior
            commit()
        }
    }
}