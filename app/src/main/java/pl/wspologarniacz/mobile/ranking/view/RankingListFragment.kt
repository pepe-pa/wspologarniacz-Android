package pl.wspologarniacz.mobile.ranking.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.swipe_refresh_recycler_view_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.ranking.repository.model.Ranking
import pl.wspologarniacz.mobile.ranking.viewmodel.RankingsListViewModel
import javax.inject.Inject

class RankingListFragment : DaggerFragment() {

    private val TAG = "RankingListFragment"

    @Inject
    lateinit var factory: ViewModelFactory<RankingsListViewModel>

    private val viewModel by lazy {
        ViewModelProviders.of(this, factory)[RankingsListViewModel::class.java]
    }

    private val adapter by lazy {
        RankingsListAdapter {
            onItemClicked(it)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.swipe_refresh_recycler_view_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter

        viewModel.rankings.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

    }

    private fun onItemClicked(ranking: Ranking) {
        Log.i(TAG, "$ranking")
    }
}
