package com.iremcelikbilek.androidviews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.iremcelikbilek.androidviews.R
import com.iremcelikbilek.androidviews.model.OnBoardingData

class ViewPagerAdapter(private var context: Context, private  var onBoardingDataList: List<OnBoardingData>) : PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.view_pager_layout, container,false)
        val title: TextView = view.findViewById(R.id.title_txt)

        title.text = onBoardingDataList[position].title

        container.addView(view)

        return view
    }
}