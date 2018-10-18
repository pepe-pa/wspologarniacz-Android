package pl.wspologarniacz.mobile.ranking.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.ranking_standing_activity_layout.*
import pl.wspologarniacz.mobile.R
import pl.wspologarniacz.mobile.common.utils.load
import pl.wspologarniacz.mobile.common.utils.setupDynamicShadowWhenScroll
import pl.wspologarniacz.mobile.members.repository.model.Member
import pl.wspologarniacz.mobile.members.repository.model.MemberStatus
import pl.wspologarniacz.mobile.ranking.repository.model.RankingStanding
import java.util.*

class RankingStandingActivity : AppCompatActivity() {


    private val adapter by lazy {
        RankingStandingAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ranking_standing_activity_layout)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Sprzątanie ^^"

        rankingRecyclerView.adapter = adapter


        appBar.setupDynamicShadowWhenScroll(rankingRecyclerView)

        val mock = mockData()
        val others = mock.withIndex().filter { it.index > 2 }.map { it.value }
        val top = mock.withIndex().filter { it.index < 3 }.map { it.value }

        fillTopPlaces(top[0], top[1], top[2])
        adapter.submitList(others)
    }


    private fun mockData(): List<RankingStanding> {
        val members = listOf(
                Member("https://api.adorable.io/avatars/285/22.png", "Isco"),
                Member("https://api.adorable.io/avatars/285/15.png", "Valverde"),
                Member("https://api.adorable.io/avatars/285/24.png", "Ceballos"),
                Member("https://api.adorable.io/avatars/285/10.png", "Modric"),
                Member("https://api.adorable.io/avatars/285/8.png", "Kross"),
                Member("https://api.adorable.io/avatars/285/14.png", "Casemiro"),
                Member("https://api.adorable.io/avatars/285/12.png", "Marcelo", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/4.png", "Sergio Ramos", MemberStatus.PENDING_INVITATION),
                Member("https://api.adorable.io/avatars/285/2.png", "Dani Carvajal", MemberStatus.WAITING_FOR_ACCEPTANCE),
                Member("https://api.adorable.io/avatars/285/5.png", "Varane", MemberStatus.MEMBER),
                Member("https://api.adorable.io/avatars/285/6.png", "Nacho", MemberStatus.MEMBER)
        )

        val random = Random()

        return listOf(
                RankingStanding(0, members[random.nextInt(members.size)], 1, 5000),
                RankingStanding(1, members[random.nextInt(members.size)], 2, 4000),
                RankingStanding(2, members[random.nextInt(members.size)], 3, 3000),
                RankingStanding(3, members[random.nextInt(members.size)], 4, 2000),
                RankingStanding(4, members[random.nextInt(members.size)], 5, 1000),
                RankingStanding(5, members[random.nextInt(members.size)], 6, 500),
                RankingStanding(6, members[random.nextInt(members.size)], 7, 250),
                RankingStanding(7, members[random.nextInt(members.size)], 8, 245),
                RankingStanding(8, members[random.nextInt(members.size)], 9, 242),
                RankingStanding(9, members[random.nextInt(members.size)], 10, 211),
                RankingStanding(10, members[random.nextInt(members.size)], 11, 204),
                RankingStanding(11, members[random.nextInt(members.size)], 12, 200)

        )
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun fillTopPlaces(first: RankingStanding, second: RankingStanding, third: RankingStanding) {
        with(first) {
            firstPlaceImageView.load(member.avatar, RequestOptions.circleCropTransform())
            firstPlacePoints.text = points.toString()
            firstPlaceUsername.text = member.name
        }

        with(second) {
            secondPlaceImageView.load(member.avatar, RequestOptions.circleCropTransform())
            secondPlacePoints.text = points.toString()
            secondPlaceUsername.text = member.name
        }


        with(third) {
            thirdPlaceImageView.load(member.avatar, RequestOptions.circleCropTransform())
            thirdPlacePoints.text = points.toString()
            thirdPlaceUsername.text = member.name
        }

    }
}