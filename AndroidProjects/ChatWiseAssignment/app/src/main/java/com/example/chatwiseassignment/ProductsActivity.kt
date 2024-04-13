package com.example.chatwiseassignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatwiseassignment.Adapter.RecyclerViewAdapter
import com.example.chatwiseassignment.ApiService.RetrofitInstance
import com.example.chatwiseassignment.Data.Product
import com.example.chatwiseassignment.Data.Prosucts
import com.example.chatwiseassignment.databinding.ActivityProductsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var binding: ActivityProductsBinding
    }

    lateinit var ProductList:List<Product>
    lateinit var RecyclerView:RecyclerView
    lateinit var Adapter:RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the RecyclerView from the binding
        RecyclerView = binding.RecyclerView
        // Create an instance of Retrofit service to fetch products
        val retrofitdata = RetrofitInstance.retrofit.GetProducts()
        retrofitdata.enqueue(object : Callback<Prosucts?> {
            override fun onResponse(call: Call<Prosucts?>, response: Response<Prosucts?>) {
                // Handle successful response
                val mydata = response.body()
                ProductList = mydata?.products!!
                // Initialize and set up the adapter for the RecyclerView
                Adapter = RecyclerViewAdapter(this@ProductsActivity, ProductList)
                RecyclerView.layoutManager = LinearLayoutManager(this@ProductsActivity)
                RecyclerView.adapter = Adapter
            }

            override fun onFailure(call: Call<Prosucts?>, t: Throwable) {
                // Log failure message
                Log.d("Product Activity", "onfailure" + t.message)
            }
        })
    }
}