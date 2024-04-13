package com.example.chatwiseassignment.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatwiseassignment.Data.Product
import com.example.chatwiseassignment.ProductsActivity
import com.example.chatwiseassignment.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

// Adapter class for the RecyclerView in ProductsActivity
data class RecyclerViewAdapter(val context: Activity, val ProductsList: List<Product>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // Create a new ViewHolder when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        // Inflate the layout for each item in the RecyclerView
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_design, parent, false)
        return ViewHolder(itemView)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        // Get the product at the current position
        val product = ProductsList[position]

        // Set the visibility of the progress bar to invisible
        ProductsActivity.binding.pb.visibility = View.INVISIBLE

        // Load the product thumbnail image using Picasso library
        Picasso.get().load(product.thumbnail).into(holder.productImage)

        // Set the title and description of the product
        holder.title.text = product.title
        holder.description.text = product.brand
    }

    // Return the total number of items in the RecyclerView
    override fun getItemCount(): Int {
        return ProductsList.size
    }

    // ViewHolder class to hold the views for each item in the RecyclerView
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize the views
        val title: TextView = itemView.findViewById(R.id.Product_title)
        val description: TextView = itemView.findViewById(R.id.Product_description)
        val productImage: ShapeableImageView = itemView.findViewById(R.id.Product_Image)
    }
}
