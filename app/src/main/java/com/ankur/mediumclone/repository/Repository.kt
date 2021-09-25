package com.ankur.mediumclone.repository

import android.util.Log
import com.ankur.mediumclone.model.News
import com.ankur.mediumclone.model.Responsee
import com.ankur.mediumclone.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {

     fun getAllNewsList(
        q: String? = null,
        from: String? = null,
        to: String? = null,
        sortBy: String? = null,
        apiKey: String
    ): ArrayList<News> {

        var newsList: ArrayList<News> = ArrayList()
        RetrofitService
            .getInstance()
            .getAllNewsList(
                q,
                from,
                to,
                sortBy,
                apiKey
            )
            .enqueue(object : Callback<Responsee> {
                override fun onResponse(call: Call<Responsee>, responsee: Response<Responsee>) {

                    val parent = responsee.body() as Responsee
                    newsList = parent.articles
                    Log.d("newsList", newsList.toString())
                }

                override fun onFailure(call: Call<Responsee>, t: Throwable) {
                    Log.d("data", t.toString())
                }
            })

        return newsList
    }
}