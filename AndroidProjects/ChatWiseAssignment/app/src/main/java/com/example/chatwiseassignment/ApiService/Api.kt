package com.example.chatwiseassignment.ApiService

import com.example.chatwiseassignment.Data.Product
import com.example.chatwiseassignment.Data.Prosucts
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("products")
    fun GetProducts(): Call<Prosucts>
}