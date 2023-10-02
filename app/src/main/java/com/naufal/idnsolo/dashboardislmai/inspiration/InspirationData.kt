package com.naufal.idnsolo.dashboardislmai.inspiration

import android.icu.text.Transliterator.Position
import com.naufal.idnsolo.dashboardislmai.R

object InspirationData {
    private val inspirationImages = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,
        R.drawable.img_inspiration
    )

    val listData: ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in inspirationImages.indices){
                val inspiration = InspirationModel()
                inspiration.inspirationImage = inspirationImages[position]
                list.add(inspiration)
            }

            return list
        }

}