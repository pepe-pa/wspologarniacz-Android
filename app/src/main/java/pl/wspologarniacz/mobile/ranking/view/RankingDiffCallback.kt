package pl.wspologarniacz.mobile.ranking.view

import androidx.recyclerview.widget.DiffUtil
import pl.wspologarniacz.mobile.ranking.repository.model.Ranking

object RankingDiffCallback : DiffUtil.ItemCallback<Ranking>() {
    override fun areItemsTheSame(oldItem: Ranking, newItem: Ranking): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Ranking, newItem: Ranking): Boolean {
        return oldItem == newItem
    }

}
