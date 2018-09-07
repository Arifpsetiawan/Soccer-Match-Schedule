package com.dicoding.schedulefootballapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.match_detail.*

class DetailActivity : AppCompatActivity(), DetailView {


    lateinit var event: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_detail)
        event = intent.getSerializableExtra("event") as Event
        withDetail()
        val presenter = DetailPresenter(this)
        presenter.getTeamBadge(event.strHomeTeam)
        presenter.getTeamBadge(event.strAwayTeam)

    }

    private fun withDetail() {
        date.text = event.dateEvent ?: " "
        teamHome.text = event.strHomeTeam ?: " "
        scoreHome.text = event.intHomeScore ?: " "
        homeFormation.text = event.strHomeFormation ?: " "
        homeGoals.text = parserGoal(event.strHomeGoalDetails ?: " ")
        homeShots.text = event.intHomeShots?.toString()
        homeGk.text = parserGoal(event.strHomeLineupGoalkeeper ?: " ")
        homeDef.text = parser(event.strHomeLineupDefense ?: " ")
        homeMdf.text = parser(event.strHomeLineupMidfield ?: " ")
        homeOfen.text = parser(event.strHomeLineupForward ?: " ")
        homeSubs.text = parser(event.strHomeLineupSubstitutes ?: " ")

        teamAway.text = event.strAwayTeam ?: " "
        scoreAway.text = event.intAwayScore ?: " "
        awayFormation.text = event.strAwayFormation ?: " "
        awayGoals.text = parserGoal(event.strAwayGoalDetails ?: " ")
        awayShots.text = event.intAwayShots?.toString()
        awayGk.text = parserGoal(event.strAwayLineupGoalkeeper ?: " ")
        awayDef.text = parser(event.strAwayLineupDefense ?: " ")
        awayMdf.text = parser(event.strAwayLineupMidfield ?: " ")
        awayOfen.text = parser(event.strAwayLineupForward ?: " ")
        awaySubs.text = parser(event.strAwayLineupSubstitutes ?: " ")

    }

    private fun parserGoal(input: String): String {
        return input.replace(";", "\n", false)
    }

    private fun parser(input: String): String {
        return input.replace("; ", "\n", false)
    }

    override fun showTeamEmblem(team: Team?) {
        if (team?.teamName.equals(event.strHomeTeam)) {
            Glide.with(this).load(team?.teamBadge).into(homeLogo)
        } else if (team?.teamName.equals(event.strAwayTeam)) {
            Glide.with(this).load(team?.teamBadge).into(awayLogo)
        }

    }
}