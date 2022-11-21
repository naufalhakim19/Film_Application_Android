package com.example.submission1_filmapplication

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission1_filmapplication.fragment.FragmentFavoriteMovie
import com.example.submission1_filmapplication.fragment.FragmentFavoriteTvshow

class PagerFavorite(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TITLE = intArrayOf(R.string.movieTabs, R.string.tvTabs)
    }

    override fun getCount(): Int = TITLE.size


    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FragmentFavoriteMovie()
            1 -> FragmentFavoriteTvshow()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        context.resources.getString(TITLE[position])

}