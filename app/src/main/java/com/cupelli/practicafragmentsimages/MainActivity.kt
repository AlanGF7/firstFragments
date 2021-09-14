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

    private lateinit var imagesArray: Array<Images> //Creamos un arreglo de tipo "Images", como nuestra clase
    private lateinit var btnBack: Button
    private lateinit var photoBinary: ImageView
    private lateinit var btnNext: Button
    private lateinit var btnInfo: Button
    private lateinit var btnFav: Button
    private lateinit var Imagenes: Images
    private var centinel = 0

    private lateinit var mainImage: ImageView //No hallé forma de poner un onClick() en una imagen
    private lateinit var textPhotoMiddle: TextView
    private lateinit var photoPreferences: ImageButton

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

        Imagenes = Images()
        initView()
    }

    private fun initView()
    {
        btnBack = findViewById(R.id.btnBack)
        photoBinary = findViewById(R.id.photoBinary)
        btnNext = findViewById(R.id.btnNext)
        btnInfo = findViewById(R.id.btnInfo)
        //Cargamos las imágenes en nuestro arreglo, llamando la función getImages en Images
        imagesArray = Imagenes.getImages()

        bringImages()
        changeImagesByClick()
    }

    public fun replaceFragment(fragment: Fragment)
    {
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

    private fun playSound(sound: Int) = MediaPlayer.create(this, sound).start()

    private fun bringImages()
    {
        photoBinary.setImageResource(imagesArray[centinel].image)
    }

    private fun changeImagesByClick(){
        btnBack.setOnClickListener{
            if(centinel == 0) { centinel = imagesArray.size - 1 }//En caso de que centinel sea 0, restaremos un valor al arreglo
            else { centinel -= 1 }
            bringImages()
        }

        btnNext.setOnClickListener{
            if(centinel ==  imagesArray.size - 1) {centinel = 0} //En caso de que centinel sea 0, restaremos un valor al arreglo
            else centinel += 1
            bringImages()
        }
    }

}