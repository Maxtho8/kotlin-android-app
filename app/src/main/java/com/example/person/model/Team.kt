package com.example.person.model

class Team (var name: String) {


    var members: MutableList<PersonViewModel>
    val chief : PersonViewModel

    init {
        this.chief = PersonViewModel(Person("Arnaud", "Castelltort", "IG5"))
        this.members = listOf<PersonViewModel>(
            PersonViewModel(Person("Christophe", "Fiorio", "DO4")),
            PersonViewModel(Person("Vincent", "Berry", "IG3")),
            PersonViewModel(Person("Anne-Laure", "Villaret", "IG4")),
            chief
        ).toMutableList()
    }


    override fun toString() : String {
        return name + " " + members
    }
}