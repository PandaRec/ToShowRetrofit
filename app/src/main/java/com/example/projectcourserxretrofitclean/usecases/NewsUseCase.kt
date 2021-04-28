package com.example.projectcourserxretrofitclean.usecases

import com.example.projectcourserxretrofitclean.api.ApiService
import com.example.projectcourserxretrofitclean.pojo.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsUseCase {
    private val fields= "id,title,slug,publication_date,description,images"

    fun getNews(): Observable<News> {
        return ApiService.api.getNews(fields)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}