package com.cupelli.practicafragmentsimages

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var Imagenes: Images
    private var centinel = 0

    override fun onResume() {
        super.onResume()
        Imagenes = Images()

        initView()
    }

    private lateinit var imagesArray: Array<Images> //Creamos un arreglo de tipo "Images", como nuestra clase
    private lateinit var btnBack: Button
    private lateinit var photoBinary: ImageView
    private lateinit var btnNext: Button
    private lateinit var btnInfo: Button
    private lateinit var btnFav: Button

    private fun initView(){
        btnBack = requireView().findViewById(R.id.btnBack)
        photoBinary = requireView().findViewById(R.id.photoBinary)
        btnNext = requireView().findViewById(R.id.btnNext)
        btnInfo = requireView().findViewById(R.id.btnInfo)
        //Cargamos las imágenes en nuestro arreglo, llamando la función getImages en Images
        imagesArray = Imagenes.getImages()

        bringImages()
        changeImagesByClick()
    }

    private fun changeImagesByClick(){
        btnBack.setOnClickListener{
            if(centinel == 0) { centinel = imagesArray.size - 1 }//En caso de que centinel sea 0, restaremos un valor al arreglo
            else { centinel -= 1 }
            bringImages()
        }


        btnInfo.setOnClickListener{
            (requireActivity() as MainActivity).replaceFragment(middleFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("selectedImage", imagesArray[centinel])
                }
            })
        }

        btnNext.setOnClickListener{
            if(centinel ==  imagesArray.size - 1) {centinel = 0} //En caso de que centinel sea 0, restaremos un valor al arreglo
            else centinel += 1
            bringImages()
        }
    }

    private fun bringImages()
    {
        photoBinary.setImageResource(imagesArray[centinel].image)
    }

}