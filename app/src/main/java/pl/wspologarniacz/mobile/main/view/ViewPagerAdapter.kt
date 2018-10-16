package pl.wspologarniacz.mobile.main.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.members.view.MembersFragment
import pl.wspologarniacz.mobile.tasks.view.TaskListFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager) {
    private val fragmentCache = hashMapOf<Int, Fragment>()


    override fun getItem(position: Int): Fragment {
        return fragmentCache[position] ?: getFragmentInstance(position).apply {
            fragmentCache[position] = this
        }
    }

    override fun getCount() = 4

    fun setupTabIcons(tabLayout: TabLayout) {

        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_people_in_group)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_task_list)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_schedule)
        tabLayout.getTabAt(3)?.setIcon(R.drawable.ic_ranking)
    }

    private fun getFragmentInstance(position: Int) = when (position) {
        0 -> MembersFragment()
        1 -> TaskListFragment()
        2 -> Fragment()
        else -> Fragment()
    }
}