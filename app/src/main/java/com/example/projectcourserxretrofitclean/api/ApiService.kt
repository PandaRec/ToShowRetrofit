package com.example.projectcourserxretrofitclean.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
   private const val BASE_URL="https://kudago.com/"

//    private val logger = run {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        httpLoggingInterceptor.apply {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        }
//    }

    //private val okHttp = OkHttpClient.Builder().addInterceptor(logger).build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        //.client(okHttp)
        .baseUrl(BASE_URL)
        .build()

    val api = retrofit.create(ApiFactory::class.java)

}