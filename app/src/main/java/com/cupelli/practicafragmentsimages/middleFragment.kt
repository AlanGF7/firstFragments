package com.cupelli.practicafragmentsimages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView


class middleFragment : Fragment(R.layout.fragment_middle)
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val photoMiddle : ImageView = view.findViewById<ImageView>(R.id.photoMiddle)

        /*photoMiddle.setOnClickListener{
            (requireActivity() as MainActivity).replaceFragment(detailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("Selected Image",)
                }
            })
        }*/

      /*  imgv_Photo.setOnClickListener{
            (requireActivity() as MainActivity).replaceFragment(ImageInfo().apply {
                arguments = Bundle().apply {
                    putParcelable("selected Clothe", ropa[index])
                }

            })

            sound(R.raw.vistas)
        }*/
        


    }

}