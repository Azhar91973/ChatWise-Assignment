package com.example.chatwiseassignment.Data

import com.example.chatwiseassignment.Data.Product

data class Prosucts(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)