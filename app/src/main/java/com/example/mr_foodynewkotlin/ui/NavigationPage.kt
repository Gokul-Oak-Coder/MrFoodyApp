package com.example.mr_foodynewkotlin.ui

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.databinding.ActivityNavigationPageBinding

class NavigationPage : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationPageBinding
    private lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomView = binding.bottomNavigationView
        val fab = binding.fab
        val navController = findNavController(R.id.FoodyNavHostFragment)

//        bottomView.let {it ->
//            val builder = AlertDialog.Builder(context)
//            val dialogView = layoutInflater.inflate(R.layout.progress_bar_style, null)
//            val message = dialogView.findViewById<TextView>(R.id.progressMessage)
//            message.text = "Logging In..."
//            message.setTextColor(Color.WHITE)
//            builder?.setView(dialogView)
//            builder?.setCancelable(false)
//            val dialog = builder?.create()!!
//            dialog.show()
//
//            it.background = null
//            it.menu.getItem(2).isEnabled = false
//            it.setupWithNavController(navController)
//        }
        bottomView.background=null
        bottomView.menu.getItem(2).isEnabled = false
        bottomView.setupWithNavController(navController)
//        //NavigationUI.setupWithNavController(bottomView, navController)

        fab.setOnClickListener {
            navController.navigate(R.id.favouriteFragment)
            }


    }
}