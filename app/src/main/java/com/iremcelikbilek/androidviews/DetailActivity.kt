package com.iremcelikbilek.androidviews

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.iremcelikbilek.androidviews.adapter.DetailViewPagerAdapter
import com.iremcelikbilek.androidviews.adapter.ViewPagerAdapter
import com.iremcelikbilek.androidviews.model.DetailData
import com.iremcelikbilek.androidviews.model.OnBoardingData

class DetailActivity : AppCompatActivity() {

    var detailViewPagerAdapter: DetailViewPagerAdapter? = null
    var tabIndicatorDetail: TabLayout? = null
    var viewPagerDetail: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        tabIndicatorDetail = findViewById(R.id.tab_indicator_detail)

        val detailDataList: MutableList<DetailData> = ArrayList()
        detailDataList.add(DetailData(R.drawable.detail_background))
        detailDataList.add(DetailData(R.drawable.detail_background))
        detailDataList.add(DetailData(R.drawable.detail_background))
        detailDataList.add(DetailData(R.drawable.detail_background))
        detailDataList.add(DetailData(R.drawable.detail_background))

        setOnBoardingViewPagerAdapter(detailDataList)
    }

    private fun setOnBoardingViewPagerAdapter(detailDataList: List<DetailData>) {
        viewPagerDetail = findViewById<ViewPager>(R.id.view_pager_detail)
        detailViewPagerAdapter = DetailViewPagerAdapter(this, detailDataList)
        viewPagerDetail!!.adapter = detailViewPagerAdapter
        tabIndicatorDetail?.setupWithViewPager(viewPagerDetail)
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