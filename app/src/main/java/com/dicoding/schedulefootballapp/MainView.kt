package com.dicoding.schedulefootballapp

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(leagues: List<League>)
    fun showTeamList(teams: List<Team>)
    fun showMatchList(events: List<Event>)
}