package com.example.visitablepattern.data.remote

import com.example.visitablepattern.data.response.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("visitor-pattern")
    fun getMainMenu(): Call<MainResponse>
}