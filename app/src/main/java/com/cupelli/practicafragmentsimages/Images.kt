package com.cupelli.practicafragmentsimages

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Images(
    var image: Int = R.drawable.purple1,
    var description: Descriptions = Descriptions.PURPLE1,
    //var imageInfo: String = "",
    var isFavorite: Boolean = false
): Parcelable {
    companion object {
        val imagesArray = arrayOf(
            Images(R.drawable.purple1, description = Descriptions.PURPLE1,false),
            Images(R.drawable.ic_piano, description = Descriptions.PIANO,false),
            Images(R.drawable.purple2, description = Descriptions.PURPLE2,false),
            Images(R.drawable.ic_cat, description = Descriptions.CAT,false),
            Images(R.drawable.purple3, description = Descriptions.PURPLE3,false),
            Images(R.drawable.ic_dog, description = Descriptions.DOG,false),
            Images(R.drawable.purple4, description = Descriptions.PURPLE4,false),
            Images(R.drawable.ic_trading, description = Descriptions.TRADING,false),
            Images(R.drawable.purple5, description = Descriptions.PURPLE5,false),
            Images(R.drawable.ic_violin, description = Descriptions.VIOLIN,false),
        )
    }

    fun isFavorite(position: Int, isFavorite: Boolean) { imagesArray[position].isFavorite = isFavorite }

    fun getImages() = imagesArray
}