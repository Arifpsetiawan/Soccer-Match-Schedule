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
        date.text = event.eventDate ?: " "
        team_home.text = event.strHomeTeam ?: " "
        score_home.text = event.intHomeScore ?: " "
        home_formation.text = event.strHomeFormation ?: " "
        home_goal.text = parserGoal(event.strHomeGoal ?: " ")
        home_shot.text = event.intHomeShot?.toString()
        home_goalkeeper.text = parserGoal(event.strHomeGoalkeeper ?: " ")
        home_defense.text = parser(event.strHomeDefense ?: " ")
        home_midlefield.text = parser(event.strHomeMidfield ?: " ")
        home_forward.text = parser(event.strHomeForward ?: " ")
        home_subtituties.text = parser(event.strHomeSubstitutes ?: " ")

        team_away.text = event.strAwayTeam ?: " "
        score_away.text = event.intAwayScore ?: " "
        away_formation.text = event.strAwayFormation ?: " "
        away_goal.text = parserGoal(event.strAwayGoal ?: " ")
        away_shot.text = event.intAwayShot?.toString()
        away_goalkeeper.text = parserGoal(event.strAwayGoalkeeper ?: " ")
        away_defense.text = parser(event.strAwayDefense ?: " ")
        away_midlefield.text = parser(event.strAwayMidfield ?: " ")
        away_forward.text = parser(event.strAwayForward ?: " ")
        away_subtituties.text = parser(event.strAwaySubstitutes ?: " ")

    }

    private fun parserGoal(input: String): String {
        return input.replace(";", "\n", false)
    }

    private fun parser(input: String): String {
        return input.replace("; ", "\n", false)
    }

    override fun showTeamLogo(team: Team?) {
        if (team?.teamNameMain.equals(event.strHomeTeam)) {
            Glide.with(getApplicationContext()).load(team?.teamLogo).into(logo_home)
        } else if (team?.teamNameMain.equals(event.strAwayTeam)) {
            Glide.with(getApplicationContext()).load(team?.teamLogo).into(logo_away)
        }

    }
}