package pl.wspologarniacz.mobile.main.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import pl.wspologarniacz.mobile.group.view.GroupFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager) {
    private val fragmentCache = hashMapOf<Int, Fragment>()


    override fun getItem(position: Int): Fragment {
        return fragmentCache[position] ?: getFragment(position).apply {
            fragmentCache[position] = this
        }
    }

    override fun getCount() = 4

    override fun getPageTitle(position: Int): CharSequence? {
        return position.toString()
    }

    private fun getFragment(position: Int) = when (position) {
        0 -> GroupFragment()
        1 -> Fragment()
        2 -> GroupFragment()
        else -> Fragment()
    }
}