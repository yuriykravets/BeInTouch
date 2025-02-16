package com.partitionsoft.beintouch.presentation.onboarding

import androidx.annotation.DrawableRes
import com.partitionsoft.beintouch.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Be in touch with whole world",
        "Explore different news from different parts of the planet",
        R.drawable.onboarding1
    ),
    Page(
        "Be in touch with whole world",
        "Explore different news from different parts of the planet",
        R.drawable.onboarding2
    ),
    Page(
        "Be in touch with whole world",
        "Explore different news from different parts of the planet",
        R.drawable.onboarding3
    )
)