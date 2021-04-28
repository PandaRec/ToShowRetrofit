package com.example.projectcourserxretrofitclean.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class News(
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
    var results: List<Result> = listOf()
)

data class Result (
    @SerializedName("id")
    @Expose
    var id: Int = 0,

    @SerializedName("publication_date")
    @Expose
    var publicationDate: Int = 0,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("slug")
    @Expose
    var slug: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("images")
    @Expose
    var images: List<Image>? = listOf()
)

data class Image (
    @SerializedName("image")
    @Expose
    var image: String? = null

)
