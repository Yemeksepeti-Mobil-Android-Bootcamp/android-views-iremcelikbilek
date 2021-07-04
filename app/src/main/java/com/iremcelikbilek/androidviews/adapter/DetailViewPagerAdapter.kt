package com.iremcelikbilek.androidviews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.iremcelikbilek.androidviews.R
import com.iremcelikbilek.androidviews.model.DetailData
import com.iremcelikbilek.androidviews.model.OnBoardingData

class DetailViewPagerAdapter(private var context: Context, private  var detailDataList: List<DetailData>) : PagerAdapter() {
    override fun getCount(): Int = detailDataList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.detail_view_pager_layout, container, false)
        val detailImg: ImageView = view.findViewById(R.id.detail_img)

        detailImg.setImageResource(detailDataList[position].img)

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}