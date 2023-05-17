package com.w1nxclub.winxvideo.presentation.detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RelativeFragment()
            1 -> MoreDetailFragment()
            else -> RelativeFragment()
        }
    }
}