package com.iremcelikbilek.androidviews

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.iremcelikbilek.androidviews.adapter.ViewPagerAdapter
import com.iremcelikbilek.androidviews.model.OnBoardingData

class MainActivity : AppCompatActivity() {

    var viewPagerAdapter: ViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    lateinit var btnSignUp: Button
    lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        tabLayout = findViewById(R.id.tab_indicator)
        btnSignUp = findViewById(R.id.btn_sign_up)
        btnLogIn = findViewById(R.id.btn_log_in)

        btnSignUp.setOnClickListener {
            val i = Intent(applicationContext, DetailActivity::class.java)
            startActivity(i)
        }

        btnLogIn.setOnClickListener {
            val i = Intent(applicationContext, DetailActivity::class.java)
            startActivity(i)
        }

        val onBoardingDataList: MutableList<OnBoardingData> = ArrayList()
        onBoardingDataList.add(OnBoardingData("Shop for exceptional urban clothings for your everyday life"))
        onBoardingDataList.add(OnBoardingData("Shop for exceptional urban clothings for your everyday life"))
        onBoardingDataList.add(OnBoardingData("Shop for exceptional urban clothings for your everyday life"))
        onBoardingDataList.add(OnBoardingData("Shop for exceptional urban clothings for your everyday life"))

        setOnBoardingViewPagerAdapter(onBoardingDataList)
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingDataList: List<OnBoardingData>) {
        viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPagerAdapter = ViewPagerAdapter(this, onBoardingDataList)
        viewPager!!.adapter = viewPagerAdapter
        tabLayout?.setupWithViewPager(viewPager)
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

}