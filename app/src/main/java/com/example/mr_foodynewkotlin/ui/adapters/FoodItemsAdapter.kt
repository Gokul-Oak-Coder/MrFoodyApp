package com.example.mr_foodynewkotlin.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.ui.model.FoodItem

class FoodItemsAdapter : RecyclerView.Adapter<FoodItemsAdapter.FoodItemViewHolder>() {

    inner class FoodItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val ratingBar: RatingBar = itemView.findViewById(R.id.rating)
        val image: ImageView = itemView.findViewById(R.id.food_img)
        val title: TextView = itemView.findViewById(R.id.food_title)
        val price: TextView = itemView.findViewById(R.id.txt_price)
//        val llBackground: LinearLayout = itemView.findViewById(R.id.ll_background)
//        val cardView: CardView = itemView.findViewById(R.id.food_background)
    }

    private val diffUtil = object : DiffUtil.ItemCallback<FoodItem>(){
        override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        return FoodItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.food_holder, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        val food = differ.currentList[position]

        holder.apply {
            ratingBar.rating = food.rating
            Glide.with(itemView.context).load(food.image).into(image)
            title.text = food.name
            price.text = food.price.toString()
            title.text = food.name
            itemView.setOnClickListener {
                onItemClickListener?.let { it(food) }
            }
        }
    }
    private var onItemClickListener:((FoodItem) -> Unit) ? = null

    fun setOnItemClickListener(listener : (FoodItem) -> Unit){
        onItemClickListener = listener

    }
    fun submitList(list: List<FoodItem>) {
        differ.submitList(list)
    }


}