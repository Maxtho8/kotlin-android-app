package com.example.person.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.person.model.Person

data class PersonState (var firstname: String, var lastname: String, val editing: Boolean)

class PersonViewModel (person : Person) : ViewModel(){

    val state : MutableLiveData<PersonState> = MutableLiveData<PersonState>(PersonState(person.firstname, person.lastname, false))

    var lastname : String
        get() {
            return state.value!!.lastname
        }
        set(value){
            state.value = state.value?.copy(firstname = value)
        }

    var firstname : String
        get() {
            return state.value!!.firstname
        }
        set(value){
            state.value = state.value?.copy(firstname = value)
        }


    var edited : Boolean
        get(){
            return this.state!!.value!!.editing
        }
        set(value : Boolean){
            state.value = state.value!!.copy(editing = value)
        }

    override fun toString() : String {
        return firstname + " " + lastname
    }

}

