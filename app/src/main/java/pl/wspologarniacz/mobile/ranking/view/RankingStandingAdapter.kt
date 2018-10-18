package pl.wspologarniacz.mobile.ranking.view

import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.ranking_standing_item_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.inflate
import pl.wspologarniacz.mobile.common.utils.load
import pl.wspologarniacz.mobile.common.view.BindViewHolder
import pl.wspologarniacz.mobile.common.view.SimpleListAdapter
import pl.wspologarniacz.mobile.ranking.repository.model.RankingStanding

class RankingStandingAdapter : SimpleListAdapter<RankingStanding>(RankingStandingDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder<RankingStanding> {
        return RankingStandingViewHolder(R.layout.ranking_standing_item_layout.inflate(parent))
    }

    class RankingStandingViewHolder(view: View) : BindViewHolder<RankingStanding>(view) {


        override fun bind(item: RankingStanding) {
            place.text = item.position.toString()
            avatar.load(item.member.avatar, RequestOptions.circleCropTransform())
            username.text = item.member.name
            points.text = item.points.toString()

        }

    }

}
