package com.example.projectcourserxretrofitclean.usecases

import com.example.projectcourserxretrofitclean.api.ApiService
import com.example.projectcourserxretrofitclean.pojo.Movies
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesUseCase {
    private val fields= "id,title,poster,trailer"

    fun getMovies(): Observable<Movies> {
        return ApiService.api.getMovies(fields)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}