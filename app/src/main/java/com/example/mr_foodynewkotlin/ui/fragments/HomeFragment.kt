package com.example.mr_foodynewkotlin.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.ui.adapters.FoodItemsAdapter
import com.example.mr_foodynewkotlin.ui.adapters.FoodyCategoryAdapter
import com.example.mr_foodynewkotlin.ui.adapters.ImagesAdapter
import com.example.mr_foodynewkotlin.ui.model.CarousalItem
import com.example.mr_foodynewkotlin.ui.model.FoodItem
import com.example.mr_foodynewkotlin.ui.model.FoodList
import java.util.UUID

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView1: RecyclerView
    private lateinit var foodItemsAdapter: FoodItemsAdapter
    private lateinit var foodyCategoryAdapter: FoodyCategoryAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var lLayout: LinearLayout
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize view components
        val langTrans: ImageView = view.findViewById(R.id.lang_trans)
        viewPager = view.findViewById(R.id.viewPager2)
        lLayout = view.findViewById(R.id.lLayout)
        recyclerView = view.findViewById(R.id.recycle_food)
        recyclerView1 = view.findViewById(R.id.recycle)

        // Set up language translation button click listener
        langTrans.setOnClickListener {
            Toast.makeText(context, "Clicked on lang trans", Toast.LENGTH_SHORT).show()
        }

        // Set up ViewPager with image carousel
        setupViewPager()

        // Initialize FoodItemsAdapter
        foodItemsAdapter = FoodItemsAdapter()
        recyclerView.adapter = foodItemsAdapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        // Initialize FoodyCategoryAdapter
        foodyCategoryAdapter = FoodyCategoryAdapter(getSampleData(), context = requireContext(), onListingClick = object : FoodyCategoryAdapter.OnListingClick {
            override fun onClick(pos: Int) {
                val data = getSampleData1(pos)
                foodItemsAdapter.submitList(data)
            }
        })
        recyclerView1.adapter = foodyCategoryAdapter
        recyclerView1.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        return view
    }

    private fun setupViewPager() {
        val imageList = listOf(
            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur1}"),
            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur2}"),
            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur3}"),
            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur4}"),
            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur5}")
        )

        val imageAdapter = ImagesAdapter()
        viewPager.adapter = imageAdapter
        imageAdapter.submitList(imageList)

        val dotsImage = Array(imageList.size) { ImageView(requireContext()) }
        dotsImage.forEach {
            it.setImageResource(R.drawable.default_dot)
            lLayout.addView(it, params)
        }
        dotsImage[0].setImageResource(R.drawable.selected_dot)

        pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dotsImage.forEachIndexed { index, imageView ->
                    imageView.setImageResource(
                        if (position == index) R.drawable.selected_dot
                        else R.drawable.default_dot
                    )
                }
                super.onPageSelected(position)
            }
        }
        viewPager.registerOnPageChangeCallback(pageChangeListener)
    }

    private fun getSampleData(): List<FoodList> {
        return listOf(
            FoodList("Burger", R.drawable.burger),
            FoodList("Chicken", R.drawable.chicken),
            FoodList("Pizza", R.drawable.pizza),
            FoodList("Ice Cream", R.drawable.ice_cream),
            FoodList("Doughnut", R.drawable.doughnut)
        )
    }

    private fun getSampleData1(pos: Int): List<FoodItem> {
        return when (pos) {
            2 -> listOf(
                FoodItem(1, "Normal Pizza", 4.5f, 120, R.drawable.piz1),
                FoodItem(2, "Spicy Pizza", 5f, 200, R.drawable.piz3),
                FoodItem(3, "Red Chilli Pizza", 3.5f, 90, R.drawable.piz4),
                FoodItem(4, "Veg Pizza", 4.5f, 150, R.drawable.piz6),
                FoodItem(5, "Cheese Pizza", 4f, 100, R.drawable.cheez_piz),
                FoodItem(6, "Mini Pizza", 4.5f, 130, R.drawable.veg_piz),
                FoodItem(7, "Tomato Pizza", 3f, 80, R.drawable.tom_piz)
            )
            1 -> listOf(
                FoodItem(8, "Normal Chicken", 4.5f, 120, R.drawable.chick1),
                FoodItem(9, "Cooked Chicken", 5f, 200, R.drawable.cooked_chick),
                FoodItem(10, "Drumstick Chicken", 3.5f, 90, R.drawable.drum_chick),
                FoodItem(11, "Popeyes Chicken", 4.5f, 150, R.drawable.popeys_chick),
                FoodItem(12, "Wings Legs Piece", 4f, 100, R.drawable.wing_legs_chick),
                FoodItem(13, "Fried Chicken Wing", 4.5f, 130, R.drawable.fried_chick_wing),
                FoodItem(14, "Grill", 3f, 80, R.drawable.grill_chick)
            )
            0 -> listOf(
                FoodItem(15, "Normal Burger", 4.5f, 120, R.drawable.bur1),
                FoodItem(16, "Spicy Burger", 5f, 200, R.drawable.bur2),
                FoodItem(17, "Red Chilli Burger", 3.5f, 90, R.drawable.bur3),
                FoodItem(18, "Cheesy Burger", 4.5f, 150, R.drawable.cheez_bur),
                FoodItem(19, "Veg Burger", 4f, 100, R.drawable.veg_bur),
                FoodItem(20, "Non-Veg Burger", 4.5f, 130, R.drawable.non_bur),
                FoodItem(21, "Chilly Burger", 3f, 80, R.drawable.bur_fre)
            )
            3 -> listOf(
                FoodItem(22, "Normal Ice Cream", 4.5f, 120, R.drawable.ice1),
                FoodItem(23, "Strawberry", 5f, 200, R.drawable.ice2),
                FoodItem(24, "3 in One", 3.5f, 90, R.drawable.ice3),
                FoodItem(25, "Choco", 4.5f, 150, R.drawable.choc_ice),
                FoodItem(26, "Cone", 4f, 100, R.drawable.cone_ice),
//                FoodItem(27, "Mixed", 4.5f, 130, R.drawable.mixed_ice),
//                FoodItem(28, "Fruit Cream", 3f, 80, R.drawable.fruit_cream)
            )
            else -> emptyList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPager.unregisterOnPageChangeCallback(pageChangeListener)
    }
}









































//package com.example.mr_foodynewkotlin.ui.fragments
//
//import android.app.Dialog
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.os.Bundle
//import android.view.Gravity
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.view.Window
//import android.widget.Button
//import android.widget.ImageButton
//import android.widget.ImageView
//import android.widget.LinearLayout
//import android.widget.TextView
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewpager2.widget.ViewPager2
//import com.example.mr_foodynewkotlin.R
//import com.example.mr_foodynewkotlin.ui.adapters.FoodItemsAdapter
//import com.example.mr_foodynewkotlin.ui.adapters.FoodyAdapter
//import com.example.mr_foodynewkotlin.ui.adapters.FoodyCategoryAdapter
//import com.example.mr_foodynewkotlin.ui.adapters.ImagesAdapter
//import com.example.mr_foodynewkotlin.ui.model.CarousalItem
//import com.example.mr_foodynewkotlin.ui.model.FoodItem
//import com.example.mr_foodynewkotlin.ui.model.FoodList
//import java.util.UUID
//
//
//class HomeFragment : Fragment(R.layout.fragment_home) {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var recyclerView1: RecyclerView
//   // private lateinit var adapter: FoodyAdapter
//    private lateinit var adapter: FoodItemsAdapter
//    private lateinit var adapter1: FoodyCategoryAdapter
//    private lateinit var viewPager: ViewPager2
//    private lateinit var lLayout : LinearLayout
//    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback
//
//    private val params = LinearLayout.LayoutParams(
//        LinearLayout.LayoutParams.WRAP_CONTENT,
//        LinearLayout.LayoutParams.WRAP_CONTENT
//    ).apply {
//        setMargins(8, 0, 8, 0)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//
//        val langTrans: ImageView = view.findViewById(R.id.lang_trans)
//
//        langTrans.setOnClickListener {
//            Toast.makeText(context, "Clicked on lang trans", Toast.LENGTH_SHORT).show()
//        }
//
//        viewPager = view.findViewById(R.id.viewPager2)
//         lLayout = view.findViewById(R.id.lLayout)
//
//
//        val imageList = listOf(
//            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur1}"),
//            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur2}"),
//            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur3}"),
//            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur4}"),
//            CarousalItem(UUID.randomUUID().toString(), "android.resource://${requireContext().packageName}/${R.drawable.bur5}")
//        )
//
//        val imageAdapter = ImagesAdapter()
//        viewPager.adapter = imageAdapter
//        imageAdapter.submitList(imageList)
//
//        val dotsImage = Array(imageList.size) { ImageView(requireContext()) }
//
//        dotsImage.forEach {
//            it.setImageResource(R.drawable.default_dot)
//            lLayout.addView(it, params)
//        }
//
//        // Set default first dot selected
//        dotsImage[0].setImageResource(R.drawable.selected_dot)
//
//        pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                dotsImage.forEachIndexed { index, imageView ->
//                    imageView.setImageResource(
//                        if (position == index) R.drawable.selected_dot
//                        else R.drawable.default_dot
//                    )
//                }
//                super.onPageSelected(position)
//            }
//        }
//        viewPager.registerOnPageChangeCallback(pageChangeListener)
//
//        // Initialize RecyclerView
//        recyclerView = view.findViewById(R.id.recycle_food)
//        adapter = FoodItemsAdapter()
//        recyclerView.adapter = adapter
//        adapter.setOnItemClickListener {foodItem->
//            showBottomDialog(foodItem)
//        }
//        recyclerView.layoutManager = GridLayoutManager(context, 2)
//      //  recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//
//        recyclerView1 = view.findViewById(R.id.recycle)
//        recyclerView1.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//
//
//        // Initialize Adapter
//        adapter1 = FoodyCategoryAdapter(getSampleData(), context = requireContext(), onListingClick = object : FoodyCategoryAdapter.OnListingClick {
//            override fun onClick(pos: Int) {
//               // adapter.updateData(getSampleData1(pos))
//                val data = getSampleData1(pos)
//                adapter.submitList(data)
//            }
//        })
//        recyclerView1.adapter = adapter1
//
//
////        adapter = FoodyAdapter(getSampleData1(0)) { foodItem ->
////            // Show the FoodDetailFragment
//////            val fragment = FoodDetailFragment(foodItem)
//////            fragment.show(parentFragmentManager, "foodDetail")
////
////            showBottomDialog(foodItem)
////
////        }
//
//
//        return view
//    }
//
//    private fun getSampleData(): List<FoodList> {
//        return listOf(
//            FoodList("Burger", R.drawable.burger),
//            FoodList("Chicken", R.drawable.chicken),
//            FoodList("Pizza", R.drawable.pizza),
//            FoodList("Ice Cream", R.drawable.ice_cream),
//            FoodList("Doughnut", R.drawable.doughnut)
//        )
//    }
//
//    private fun getSampleData1(pos: Int): List<FoodItem> {
//        return when (pos) {
//            2 -> listOf(
//                FoodItem(1,"Normal Pizza", 4.5f, 120, R.drawable.piz1),
//                FoodItem(2,"Spicy Pizza", 5f, 200, R.drawable.piz3),
//                FoodItem(3,"Red Chilli Pizza", 3.5f, 90, R.drawable.piz4),
//                FoodItem(4,"Veg Pizza", 4.5f, 150, R.drawable.piz6),
//                FoodItem(5,"Cheese Pizza", 4f, 100, R.drawable.cheez_piz),
//                FoodItem(6,"Mini Pizza", 4.5f, 130, R.drawable.veg_piz),
//                FoodItem(7,"Tomato Pizza", 3f, 80, R.drawable.tom_piz)
//            )
//            1 -> listOf(
//                FoodItem(8,"Normal Chicken", 4.5f, 120, R.drawable.chick1),
//                FoodItem(9,"Cooked Chicken", 5f, 200, R.drawable.cooked_chick),
//                FoodItem(10,"Drumstick Chicken", 3.5f, 90, R.drawable.drum_chick),
//                FoodItem(11,"Popeyes Chicken", 4.5f, 150, R.drawable.popeys_chick),
//                FoodItem(12,"Wings Legs Piece", 4f, 100, R.drawable.wing_legs_chick),
//                FoodItem(13,"Fried Chicken Wing", 4.5f, 130, R.drawable.fried_chick_wing),
//                FoodItem(14,"Grill", 3f, 80, R.drawable.grill_chick)
//            )
//            0 -> listOf(
//                FoodItem(15,"Normal Burger", 4.5f, 120, R.drawable.bur1),
//                FoodItem(16,"Spicy Burger", 5f, 200, R.drawable.bur2),
//                FoodItem(17,"Red Chilli Burger", 3.5f, 90, R.drawable.bur3),
//                FoodItem(18,"Cheesy Burger", 4.5f, 150, R.drawable.cheez_bur),
//                FoodItem(19,"Veg Burger", 4f, 100, R.drawable.veg_bur),
//                FoodItem(20,"Non-Veg Burger", 4.5f, 130, R.drawable.non_bur),
//                FoodItem(21,"Chilly Burger", 3f, 80, R.drawable.bur_fre)
//            )
//            3 -> listOf(
//                FoodItem(22,"Normal Ice Cream", 4.5f, 120, R.drawable.ice1),
//                FoodItem(23,"Strawberry", 5f, 200, R.drawable.ice2),
//                FoodItem(24,"3 in One", 3.5f, 90, R.drawable.ice3),
//                FoodItem(25,"Choco", 4.5f, 150, R.drawable.choc_ice),
//                FoodItem(26,"Cone", 4f, 100, R.drawable.cone_ice),
//                FoodItem(27,"Mixed", 4.5f, 130, R.drawable.cup_ice),
//                FoodItem(28,"Choco Bar", 3f, 80, R.drawable.ice4)
//            )
//            4 -> listOf(
//                FoodItem(29,"Strawberry Doughnut", 4.5f, 120, R.drawable.dough),
//                FoodItem(30,"Choco Doughnut", 5f, 200, R.drawable.choc_dough),
//                FoodItem(31,"Six in One", 3.5f, 90, R.drawable.six_in_one)
//            )
//            else -> emptyList()
//        }
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        viewPager.unregisterOnPageChangeCallback(pageChangeListener)
//    }
//
//    private fun showBottomDialog(foodItem : FoodItem) {
//        val dialog = Dialog(requireContext())
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setContentView(R.layout.fragment_food_detail)
//        val cancelButton = dialog.findViewById<ImageView>(R.id.cancelButton)
//
//        val detail_description : TextView = dialog.findViewById(R.id.detail_description)
//        val detail_image : ImageView = dialog.findViewById(R.id.detail_image)
//        val detail_title : TextView = dialog.findViewById(R.id.detail_title)
//        val quantity_text: TextView = dialog.findViewById(R.id.quantity_text)
//        val increase_button: ImageButton = dialog.findViewById(R.id.increase_button)
//        val decrease_button: ImageButton = dialog.findViewById(R.id.decrease_button)
//        val order_button: Button = dialog.findViewById(R.id.order_button)
//        val cancel_button: Button = dialog.findViewById(R.id.cancel_button)
//
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
//            dialog.dismiss() // Close the fragment
//        }
//
//        cancel_button.setOnClickListener {
//            dialog.dismiss() // Close the fragment
//        }
//        cancelButton.setOnClickListener { dialog.dismiss() }
//        dialog.show()
//        dialog.window!!.setLayout(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
//        dialog.window!!.setGravity(Gravity.BOTTOM)
//    }
//}