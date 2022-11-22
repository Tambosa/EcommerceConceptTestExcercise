package com.aroman.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CapacityChoice(
    val capacity: Int,
    var isChosen: Boolean = false
) : Parcelable