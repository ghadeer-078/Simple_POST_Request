package com.example.simple_post_request.Model

import com.google.gson.annotations.SerializedName


data class PeopleDetailed(

    @SerializedName("name")
    var name: String? = null

)
