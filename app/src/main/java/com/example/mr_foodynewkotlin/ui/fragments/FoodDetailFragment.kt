package com.example.mr_foodynewkotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.ui.model.FoodItem


class FoodDetailFragment(private val foodItem: FoodItem) :DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val detail_description : TextView = view.findViewById(R.id.detail_description)
//        val detail_image : ImageView = view.findViewById(R.id.detail_image)
//        val detail_title : TextView = view.findViewById(R.id.detail_title)
//        val quantity_text: TextView = view.findViewById(R.id.quantity_text)
//        val increase_button: ImageButton = view.findViewById(R.id.increase_button)
//        val decrease_button: ImageButton = view.findViewById(R.id.decrease_button)
//        val order_button: Button = view.findViewById(R.id.order_button)
//        val cancel_button: Button = view.findViewById(R.id.cancel_button)

//        detail_image.setImageResource(foodItem.image)
//        detail_title.text = foodItem.name
//        detail_description.text = "Description for ${foodItem.name}" // Add description if available
//
//        var quantity = 1
//        quantity_text.text = quantity.toString()
//
//        increase_button.setOnClickListener {
//            quantity++
//            quantity_text.text = quantity.toString()
//        }
//
//        decrease_button.setOnClickListener {
//            if (quantity > 1) {
//                quantity--
//                quantity_text.text = quantity.toString()
//            }
//        }
//
//        order_button.setOnClickListener {
//            // Handle order action
//            dismiss() // Close the fragment
//        }
//
//        cancel_button.setOnClickListener {
//            dismiss() // Close the fragment
//        }
    }
    override fun onStart() {
        super.onStart()
        val window = dialog?.window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        window?.setBackgroundDrawableResource(R.color.my_red)
    }
}