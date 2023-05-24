package com.example.person.model

import android.database.Observable
import android.util.Log

class Person ( firstname: String, lastname: String,
              var promo: String) : java.util.Observable(){
    var lastname = lastname
        get() = field
        set(value){
            field = value
            Log.println(Log.VERBOSE, "Person", "set lastname: " + value)
            setChanged()
            notifyObservers()
        }
    var firstname = firstname
        get() = field
        set(value){
            field = value
            Log.println(Log.VERBOSE, "Person", "set firstname: " + value)
            setChanged()
            notifyObservers()
        }

    override fun toString() : String {
        return firstname + " " + lastname
    }
}
