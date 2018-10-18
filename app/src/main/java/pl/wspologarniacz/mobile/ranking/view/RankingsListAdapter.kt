package pl.wspologarniacz.mobile.ranking.view

import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.ranking_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.addMembersToLayout
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.view.BindViewHolder
import pl.wspologarniacz.mobile.common.view.SimpleListAdapter
import pl.wspologarniacz.mobile.ranking.repository.model.Ranking

class RankingsListAdapter(private val onClick: (Ranking) -> Any) : SimpleListAdapter<Ranking>(RankingDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder<Ranking> {
        return RankingViewHolder(R.layout.ranking_item_layout.inflate(parent))
    }

    inner class RankingViewHolder(view: View) : BindViewHolder<Ranking>(view) {

        init {
            view.setOnClickListener {
                onClick(getItem(layoutPosition))
            }
        }

        override fun bind(item: Ranking) {
            title.text = item.title
            members.addMembersToLayout(item.members)
        }

    }

}
