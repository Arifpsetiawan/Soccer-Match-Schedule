package com.dicoding.schedulefootballapp

import com.google.gson.annotations.SerializedName

data class Team(
        @SerializedName("idTeam")
        val teamMain: String? = null,

        @SerializedName("strTeam")
        val teamNameMain: String? = null,

        @SerializedName("strTeamBadge")
        val teamLogo: String? = null
)

data class TeamResonse(val teams: List<Team>)