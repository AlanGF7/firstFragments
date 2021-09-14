package com.cupelli.practicafragmentsimages

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class middleFragment : Fragment(R.layout.fragment_middle)
{

    private lateinit var imageSelected: Images
    private var ID: Int = 0 //No puedo usar lateinit porque es de tipo primitivo
    private var starredImage: Boolean = false

    private lateinit var mainImage: ImageView
    private lateinit var textPhotoMiddle: TextView
    private lateinit var photoPreferences: ImageButton


    override fun onResume() {
        super.onResume()
        imageSelected = requireArguments().getParcelable("selectedImage")?: Images()
        //ID = intent.getIntExtra("ID_Selected",0)
        starredImage = imageSelected.isFavorite
        initView()
    }


    private fun initView()
    {
        mainImage = requireView().findViewById(R.id.photoMiddle)
        textPhotoMiddle = requireView().findViewById(R.id.textPhotoMiddle)
        photoPreferences = requireView().findViewById(R.id.photoPreferences)
        mainImage.setImageResource(imageSelected.image)

        textPhotoMiddle.setText(imageSelected.description.text)

        detectFavorite()

        mainImage.setOnClickListener{
            (requireActivity() as MainActivity).replaceFragment(detailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("Image", imageSelected)
                }
            })
        }


    }

    //No puedo dejarlo sin un método, de lo contrario, no cambiaría en tiempo real la estrellita
    private fun detectFavorite() {
        if(starredImage) {photoPreferences.setImageResource(R.drawable.starpopped)}
        else {photoPreferences.setImageResource(R.drawable.starempty)}
    }



    /*fun clickFavorite(view: View) {
        starredImage = !starredImage
        Images().isFavorite(ID, starredImage)
        detectFavorite()
    }*/

}