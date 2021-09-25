package com.ankur.mediumclone.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankur.mediumclone.model.News
import com.ankur.mediumclone.repository.Repository

class MainActivityViewModel : ViewModel() {
    private val newsList = MutableLiveData<ArrayList<News>>()

    fun getAllNews(
        q: String? = null,
        from: String? = null,
        to: String? = null,
        sortBy: String? = null,
        apiKey: String
    ) {
        newsList.value = Repository.getAllNewsList(q, from, to, sortBy, apiKey)
    }


}