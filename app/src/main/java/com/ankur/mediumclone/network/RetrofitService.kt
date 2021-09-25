package com.ankur.mediumclone.network

import com.ankur.mediumclone.core.KeywordAndConstant
import com.ankur.mediumclone.model.Responsee
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("everything/")
    fun getAllNewsList(
        @Query(value = "q") q: String? = null,
        @Query(value = "from") from: String? = null,
        @Query(value = "to") to: String? = null,
        @Query(value = "sortBy") sortBy: String? = null,
        @Query(value = "apiKey") apiKey: String
    ): Call<Responsee>

    @GET("top-headlines")
    fun getTopBusinessHeadlineTodayByCountry(
        @Query(value = "country") country: String,
        @Query(value = "category") category: String? = null,
        @Query(value = "apiKey") apiKey: String
    ): Call<Responsee>

    @GET("top-headlines")
    fun getTopHeadlineFromTechCrunch(
        @Query(value = "sources") sources: String,
        @Query(value = "apiKey") apiKey: String
    ): Call<Responsee>


    @GET("everything")
    fun getAllWallStreetPublishedJournal(
        @Query(value = "domains") domains: String,
        @Query(value = "apiKey") apiKey: String
    ): Call<Responsee>


    companion object {

        private var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(KeywordAndConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}