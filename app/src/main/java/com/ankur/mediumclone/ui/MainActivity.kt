package com.ankur.mediumclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ankur.mediumclone.R
import com.ankur.mediumclone.core.KeywordAndConstant
import com.ankur.mediumclone.model.News
import com.ankur.mediumclone.repository.Repository


class MainActivity : AppCompatActivity() {

    private lateinit var newsList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        newsList = Repository.getAllNewsList(
            "tesla",
            "2021-09-24",
            "2021-09-24",
            "popularity",
            KeywordAndConstant.API_KEY
        )
    }
}