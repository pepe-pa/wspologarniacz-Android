package pl.wspologarniacz.mobile.main.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    private val fragmentCache = hashMapOf<Int, Fragment>()


    override fun getItem(position: Int): Fragment {
        return fragmentCache[position] ?: getFragment(position).apply {
            fragmentCache[position] = this
        }
    }

    override fun getCount() = 4


    private fun getFragment(position: Int) = when (position) {
        0 -> Fragment()
        1 -> Fragment()
        2 -> Fragment()
        else -> Fragment()
    }
}