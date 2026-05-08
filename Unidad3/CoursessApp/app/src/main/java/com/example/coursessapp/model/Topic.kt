package com.example.coursessapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Topic(
    @StringRes val topic_description: Int,
    val users: Int,
    @DrawableRes val icon_topic: Int
) {
}