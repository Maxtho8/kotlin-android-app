package com.example.person.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

data class TeamModelState(var name: String?)

class TeamViewModel(team: Team) : ViewModel() {
    val persons: MutableList<PersonViewModel> = team.members
    val chief : PersonViewModel = team.chief

    val state : MutableLiveData<TeamModelState> = MutableLiveData(TeamModelState(null))

    var name : String?
        get() {
            return state.value!!.name
        }
        set(value){
            state.value = state.value?.copy(name = value)
        }

}
