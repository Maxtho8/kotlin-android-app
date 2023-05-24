package com.example.person.model

class Team (var name: String) {

    var members = ArrayList<Person>()
    var chief: Person? = null

    override fun toString() : String {
        return name + " " + members
    }

    fun addMember(member: Person) {
        members.add(member)
    }



}