package com.naufal.idnsolo.dashboardislmai.doa.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoaModel(
    var title : String = "",
    var doa : String = "",
    var latin : String = "",
    var translate : String = "",
    var profile : String = "",
) : Parcelable
