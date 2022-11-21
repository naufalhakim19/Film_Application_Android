package com.example.submission1_filmapplication.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission1_filmapplication.R
import com.example.submission1_filmapplication.fragment.FragmentMovie
import com.example.submission1_filmapplication.fragment.FragmentTvShow

class AdapterTab(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(
    fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    companion object {
        private val TabName = intArrayOf(R.string.Movie, R.string.Tv_Shows)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TabName[position])
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> FragmentMovie()
        1 -> FragmentTvShow()
        else -> Fragment()
    }

    override fun getCount(): Int {
        return 2
    }


}