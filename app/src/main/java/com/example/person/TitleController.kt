package com.example.person


import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import com.example.person.model.Person
import java.util.ArrayList
import java.util.Observable
import java.util.Observer

class TitleController(val view : TitleFragment) :Observer {
    lateinit var context: MainActivity

    lateinit var title: TextView

    init {
        this.context = view.activity as MainActivity
        if (context == null) {
            println("context is null")
        } else {
            println("context is not null")
            this.title = view.textView
            title.text = context.selectedTeam.chief.toString()
            context.chief.addObserver(this)
        }
    }

    override fun update(o: Observable?, arg: Any?) {
        if ( context.selectedTeam.chief == context.selectedPerson ) {
            context.titleController.title.setText(context.selectedPerson.toString())
        }
    }
}