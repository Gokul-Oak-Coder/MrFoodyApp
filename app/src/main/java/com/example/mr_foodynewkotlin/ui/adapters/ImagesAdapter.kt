package com.example.mr_foodynewkotlin.ui.adapters

import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.ui.model.CarousalItem
import java.net.HttpURLConnection
import java.net.URL

class ImagesAdapter : ListAdapter<CarousalItem, ImagesAdapter.ViewHolder>(DiffCallback()) {

        class DiffCallback : DiffUtil.ItemCallback<CarousalItem>(){
            override fun areItemsTheSame(oldItem: CarousalItem, newItem: CarousalItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CarousalItem, newItem: CarousalItem): Boolean {
                return oldItem == newItem
            }

        }
        class ViewHolder(iteView: View): RecyclerView.ViewHolder(iteView){
            private val imageView = iteView.findViewById<ImageView>(R.id.image_vie)

            fun bindData(item: CarousalItem){
                Glide.with(itemView)
                    .load(item.url)
                    .into(imageView)
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_layout,parent,false)
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val CarousalItem = getItem(position)
            holder.bindData(CarousalItem)
        }
    }
