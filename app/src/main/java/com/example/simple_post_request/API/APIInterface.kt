package com.example.simple_post_request.API

import com.example.simple_post_request.Model.PeopleDetailed
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET("/people/")
    fun getUser(): Call<List<PeopleDetailed>>

    @Headers("Content-Type: application/json")
    @POST("/people/")
    fun addUser(@Body userData: PeopleDetailed): Call<PeopleDetailed>

}