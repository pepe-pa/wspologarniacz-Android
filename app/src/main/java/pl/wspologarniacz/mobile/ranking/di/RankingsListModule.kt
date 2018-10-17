package pl.wspologarniacz.mobile.ranking.di

import dagger.Module
import dagger.Provides
import pl.wspologarniacz.mobile.common.viewmodel.ViewModelFactory
import pl.wspologarniacz.mobile.ranking.repository.RankingRepository
import pl.wspologarniacz.mobile.ranking.viewmodel.RankingsListViewModel

@Module
class RankingsListModule {

    @Provides
    fun repository() = RankingRepository()

    @Provides
    fun viewModel(rankingRepository: RankingRepository) = RankingsListViewModel(rankingRepository)

    @Provides
    fun viewModelFactory(viewModel: RankingsListViewModel) = ViewModelFactory(viewModel)
}