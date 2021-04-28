package com.example.projectcourserxretrofitclean.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Movies (
    @SerializedName("count")
    @Expose
    var count: Int = 0,

    @SerializedName("next")
    @Expose
    var next: String? = null,

    @SerializedName("previous")
    @Expose
    var previous: Any? = null,

    @SerializedName("results")
    @Expose
    var results: List<ResultMovie> = listOf()
)

data class ResultMovie (
    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("trailer")
    @Expose
    var trailer: String? = null,

    @SerializedName("poster")
    @Expose
    var poster: Poster? = null
    )

data class Poster (
    @SerializedName("image")
    @Expose
    var image: String? = null

)

