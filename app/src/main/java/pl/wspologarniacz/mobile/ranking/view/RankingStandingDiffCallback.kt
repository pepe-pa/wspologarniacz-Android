package pl.wspologarniacz.mobile.ranking.view

import androidx.recyclerview.widget.DiffUtil
import pl.wspologarniacz.mobile.ranking.repository.model.RankingStanding

object RankingStandingDiffCallback : DiffUtil.ItemCallback<RankingStanding>() {
    override fun areItemsTheSame(oldItem: RankingStanding, newItem: RankingStanding): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RankingStanding, newItem: RankingStanding): Boolean {
        return oldItem == newItem
    }

}
