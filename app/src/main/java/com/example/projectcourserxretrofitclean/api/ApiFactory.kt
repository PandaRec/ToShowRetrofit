package com.example.projectcourserxretrofitclean.api

import com.example.projectcourserxretrofitclean.pojo.Movies
import com.example.projectcourserxretrofitclean.pojo.News
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiFactory {
    @GET("public-api/v1.4/news")
    fun getNews(
        @Query("fields") fields:String
    ): Observable<News>

    @GET("public-api/v1.4/movies")
    fun getMovies(
        @Query("fields") fields: String
    ):Observable<Movies>
}