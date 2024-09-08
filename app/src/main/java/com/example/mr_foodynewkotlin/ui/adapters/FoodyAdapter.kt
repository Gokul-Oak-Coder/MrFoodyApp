package com.example.mr_foodynewkotlin.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.ui.fragments.FoodDetailFragment
import com.example.mr_foodynewkotlin.ui.model.FoodItem

class FoodyAdapter(private var foodyList: List<FoodItem>,
                   private var selectedItem: Int = -1,
                   private val onItemClick: ((FoodItem) -> Unit)? = null)
    :RecyclerView.Adapter<FoodyAdapter.FoodyViewHolder>() {

    inner class FoodyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ratingBar: RatingBar = itemView.findViewById(R.id.rating)
        val image: ImageView = itemView.findViewById(R.id.food_img)
        val title: TextView = itemView.findViewById(R.id.food_title)
        val price: TextView = itemView.findViewById(R.id.txt_price)
        val llBackground: LinearLayout = itemView.findViewById(R.id.ll_background)
        val cardView: CardView = itemView.findViewById(R.id.food_background)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_holder, parent, false)
        return FoodyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodyViewHolder, position: Int) {
        val item = foodyList[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.name
        holder.ratingBar.rating = item.rating
        holder.price.text = item.price.toString()

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(item)
        }

        if (selectedItem == position) {
            holder.cardView.animate().scaleX(1.1f).start()
            holder.cardView.animate().scaleY(1.1f).start()
            holder.title.setTextColor(Color.WHITE)
            holder.price.setTextColor(Color.WHITE)
            holder.llBackground.setBackgroundResource(R.drawable.gradient_background)
        } else {
            holder.cardView.animate().scaleX(1f).start()
            holder.cardView.animate().scaleY(1f).start()
            holder.title.setTextColor(Color.BLACK)
            holder.price.setTextColor(Color.BLACK)
            holder.llBackground.setBackgroundResource(R.color.glass_food)
        }

//        holder.itemView.setOnClickListener {
//            selectedItem = holder.adapterPosition
//            notifyDataSetChanged()
//        }
    }

    override fun getItemCount(): Int {
        return foodyList.size
    }
    fun updateData(newData: List<FoodItem>) {
        foodyList = newData
        notifyDataSetChanged()
    }
}






































//package com.example.mr_foodynewkotlin.ui.adapters
//
//import android.graphics.Color
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.LinearLayout
//import android.widget.RatingBar
//import android.widget.TextView
//import androidx.cardview.widget.CardView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.mr_foodynewkotlin.R
//import com.example.mr_foodynewkotlin.ui.model.FoodItem
//
//class FoodyAdapter(val foodyList: List<FoodItem>, var selectedItem :Int = 0):RecyclerView.Adapter<FoodyAdapter.FoodyViewHolder>() {
//
//    inner class FoodyViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
//        var ratingBar: RatingBar = itemView.findViewById(R.id.rating)
//        var image: ImageView  = itemView.findViewById(R.id.food_img)
//        var title: TextView = itemView.findViewById(R.id.food_title)
//        var price: TextView = itemView.findViewById(R.id.txt_price)
//        var addBtn: ImageView = itemView.findViewById(R.id.addBtn)
//        var llBackground: LinearLayout = itemView.findViewById(R.id.ll_background)
//        var cardView: CardView = itemView.findViewById(R.id.card_view)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodyAdapter.FoodyViewHolder {
//       val view = LayoutInflater.from(parent.context).inflate(R.layout.food_holder, parent, false)
//        return FoodyViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: FoodyAdapter.FoodyViewHolder, position: Int) {
//        holder.image.setImageResource(foodyList[position].image)
//        holder.title.text = foodyList[position].name
//        holder.ratingBar.rating = foodyList[position].rating
//        holder.price.text = foodyList[position].price.toString()
//        if (selectedItem == position) {
//            holder.cardView.animate().scaleX(1.1f)
//            holder.cardView.animate().scaleY(1.1f)
//            holder.title.setTextColor(Color.WHITE)
//            holder.price.setTextColor(Color.WHITE)
//            holder.llBackground.setBackgroundResource(R.drawable.gradient_background)
//        } else {
//            holder.cardView.animate().scaleX(1f)
//            holder.cardView.animate().scaleY(1f)
//            holder.title.setTextColor(Color.BLACK)
//            holder.price.setTextColor(Color.BLACK)
//            holder.llBackground.setBackgroundResource(R.color.white_gray)
//        }
//
//    }
//
//    override fun getItemCount(): Int {
//        return foodyList.size
//    }
//}