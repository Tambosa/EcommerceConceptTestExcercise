package com.aroman.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ColorChoice(
    val color: String,
    var isChosen: Boolean = false
) : Parcelable