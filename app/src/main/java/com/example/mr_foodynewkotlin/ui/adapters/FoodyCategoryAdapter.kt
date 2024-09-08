package com.example.mr_foodynewkotlin.ui.adapters

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.ui.model.FoodList
import com.google.android.material.card.MaterialCardView

class FoodyCategoryAdapter(
    private var foodCategoryList: List<FoodList>,
    private var selectedItem: Int = 0,
    private var context: Context,
    private var onListingClick: OnListingClick? = null
) : RecyclerView.Adapter<FoodyCategoryAdapter.FoodyCategoryViewHolder>() {

    interface OnListingClick {
        fun onClick(pos: Int)
    }

    inner class FoodyCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImg: ImageView = itemView.findViewById(R.id.list_img)
        val foodTitle: TextView = itemView.findViewById(R.id.list_title)
        val cardView: MaterialCardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodyCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listing_holder, parent, false)
        return FoodyCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodyCategoryViewHolder, position: Int) {
        val item = foodCategoryList[position]
        holder.foodImg.setImageResource(item.image)
        holder.foodTitle.text = item.name

        // Update card view based on selection
        if (position == selectedItem) {
            holder.cardView.outlineSpotShadowColor = ContextCompat.getColor(context, R.color.my_red)
            holder.cardView.outlineAmbientShadowColor = ContextCompat.getColor(context, R.color.my_red)
            holder.cardView.strokeWidth = 2
            holder.foodTitle.setTextColor(ContextCompat.getColor(context, R.color.my_red))
            holder.foodImg.setColorFilter(ContextCompat.getColor(context, R.color.my_red), PorterDuff.Mode.SRC_IN)
        } else {
            holder.cardView.outlineSpotShadowColor = ContextCompat.getColor(context, R.color.gray1)
            holder.cardView.outlineAmbientShadowColor = ContextCompat.getColor(context, R.color.gray1)
            holder.foodTitle.setTextColor(ContextCompat.getColor(context, R.color.gray1))
            holder.foodImg.setColorFilter(ContextCompat.getColor(context, R.color.gray1), PorterDuff.Mode.SRC_IN)
            holder.cardView.strokeWidth = 0
        }

        holder.cardView.setOnClickListener {
            selectedItem = holder.adapterPosition
            notifyDataSetChanged()
            onListingClick?.onClick(selectedItem)
        }
    }

    override fun getItemCount(): Int {
        return foodCategoryList.size
    }
}





































//package com.example.mr_foodynewkotlin.ui.adapters
//
//import android.content.Context
//import android.graphics.PorterDuff
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.core.content.ContextCompat
//import androidx.recyclerview.widget.RecyclerView
//import com.example.mr_foodynewkotlin.R
//import com.example.mr_foodynewkotlin.ui.model.FoodList
//import com.google.android.material.card.MaterialCardView
//
//class FoodyCategoryAdapter(var foodCategoryList: List<FoodList>, var selectedItem : Int = 0, var context: Context,
//                           var onListingClick: FoodyCategoryAdapter.OnListingClick?
//):RecyclerView.Adapter<FoodyCategoryAdapter.FoodyCategoryViewHolder>() {
//
//    interface OnListingClick {
//        fun onClick(pos: Int)
//    }
//
//    inner class FoodyCategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
//        var foodImg : ImageView = itemView.findViewById(R.id.list_img)
//        var foodtitle : TextView = itemView.findViewById(R.id.list_title)
//        var cardView: MaterialCardView = itemView.findViewById(R.id.card_view)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodyCategoryAdapter.FoodyCategoryViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.listing_holder, parent, false)
//        return FoodyCategoryViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: FoodyCategoryAdapter.FoodyCategoryViewHolder, position: Int) {
//        holder.foodImg.setImageResource(foodCategoryList[position].image)
//        holder.foodtitle.text = foodCategoryList[position].name
//
//        holder.cardView.setOnClickListener{
//            selectedItem = getAdapterPosition();
//
//                //reset items, so that color changes where we click on card
//
//                if(onListingClick != null) {
//
//                    onListingClick.onClick(getAdapterPosition());
//                }
//                notifyDataSetChanged();
//        })
//
//        if (position == selectedItem) {
//            // Make card selected
//            holder.cardView.outlineSpotShadowColor = context.getColor(R.color.my_red)
//            holder.cardView.outlineAmbientShadowColor = context.getColor(R.color.my_red)
//            holder.cardView.strokeWidth = 2
//            holder.foodtitle.setTextColor(context.getColor(R.color.my_red))
//            holder.foodImg.setColorFilter(R.color.my_red)
//            holder.foodImg.setColorFilter(
//                ContextCompat.getColor(context, R.color.my_red),
//                PorterDuff.Mode.SRC_IN
//            )
//        } else {
//            // Make card inactive
//            holder.cardView.outlineSpotShadowColor = context.getColor(R.color.gray1)
//            holder.cardView.outlineAmbientShadowColor = context.getColor(R.color.gray1)
//            holder.foodtitle.setTextColor(context.getColor(R.color.gray1))
//            holder.foodImg.setColorFilter(
//                ContextCompat.getColor(context, R.color.gray1),
//                PorterDuff.Mode.SRC_IN
//            )
//            holder.cardView.strokeWidth = 0
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return foodCategoryList.size
//    }
//}