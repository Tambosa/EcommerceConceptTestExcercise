package com.aroman.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryChoice(
    val iconResId: Int,
    val name: String,
    var isChecked: Boolean = false
) : Parcelable