package com.cupelli.practicafragmentsimages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class detailFragment : Fragment(R.layout.fragment_detail) {

    private var source: Int = 0
    private lateinit var image: ImageView

    override fun onResume() {
        super.onResume()
        //source = intent.getIntExtra("source", R.drawable.purple1)
        source = requireArguments().getParcelable("Image")?: Images()

        image = requireView().findViewById(R.id.photoDetail)
        image.setImageResource(source)

        /*
        source = intent.getIntExtra("source", R.drawable.purple1)

        image = findViewById(R.id.photoDetail)
        image.setImageResource(source)
        */
    }


}