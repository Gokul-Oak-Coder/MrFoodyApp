package com.example.mr_foodynewkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.mr_foodynewkotlin.ui.adapters.FragmentPageAdapter
import com.example.mr_foodynewkotlin.ui.fragments.LoginTabFragment
import com.example.mr_foodynewkotlin.R
import com.example.mr_foodynewkotlin.ui.fragments.SignupTabFragment
import com.example.mr_foodynewkotlin.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val v: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val fragmentList = listOf(
            LoginTabFragment(),
            SignupTabFragment()
        )

        val adapter = FragmentPageAdapter(supportFragmentManager, lifecycle, fragmentList)

        tabLayout.addTab(tabLayout.newTab().setText("LogIn"))
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"))

        viewPager.adapter = adapter

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback()  {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.translationX = 300F
        tabLayout.alpha = v
        tabLayout.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(100).start()

    }
}