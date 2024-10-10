package com.example.hireme.network

import com.example.hireme.data.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getData(): ApiResponse
}
