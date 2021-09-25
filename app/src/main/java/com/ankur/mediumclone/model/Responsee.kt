package com.ankur.mediumclone.model

data class Responsee(
    val status: String,
    val totalResults: Int,
    val articles: ArrayList<News>
)