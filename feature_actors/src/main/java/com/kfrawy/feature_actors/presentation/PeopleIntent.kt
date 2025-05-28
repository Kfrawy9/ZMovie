package com.kfrawy.feature_actors.presentation

sealed class PeopleIntent {
    object GetTrendingPeople: PeopleIntent()
    class PersonClicked(val personId: Int): PeopleIntent()
}