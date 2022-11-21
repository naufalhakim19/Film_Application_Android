package com.example.submission1_filmapplication.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission1_filmapplication.R
import com.example.submission1_filmapplication.fragment.FragmentFavorite
import com.example.submission1_filmapplication.fragment.FragmentMovie
import com.example.submission1_filmapplication.fragment.FragmentTvShow

class AdapterPager(private val context: Context, fm: androidx.fragment.app.FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TITLE = intArrayOf(R.string.Movie, R.string.Tv_Shows, R.string.Favorite)
    }

    override fun getCount(): Int = TITLE.size

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> FragmentMovie()
        1 -> FragmentTvShow()
        2 -> FragmentFavorite()
        else -> Fragment()
    }

    override fun getPageTitle(position: Int): CharSequence? =
        context.resources.getString(TITLE[position])
}