package com.example.person

import android.util.Log
import android.widget.ArrayAdapter
import com.example.person.model.Person
import java.util.ArrayList
import java.util.Observable
import java.util.Observer

class ListController(val view : ListFragment, var list: ArrayList<Person>) : Observer{
    lateinit var context : MainActivity
    init {
        this.context = view.activity as MainActivity
        if (context == null ){
            println("context is null")
        }
        else {
            println("context is not null")
            val adapter = ArrayAdapter<Person>(
                context,
                android.R.layout.simple_list_item_1,
                list
            )
            view.listView.adapter = adapter
            view.listView.setOnItemClickListener { parent, view, position, id ->
                onClickItem(position)
            }

            for (person in list) {
                Log.println(Log.VERBOSE, "Person", "add observer: " + person)
                person.addObserver(this)
            }
        }

    }

    fun onClickItem(index : Int){
        val person = list[index]
        println("selected person : " + person)
        context.selectedPerson = person
        context.editController.textInput.setText(person.firstname)
    }

    override fun update(o: Observable?, arg: Any?) {
        val person = o as Person
        // log the chang
        Log.println(Log.VERBOSE, "Person", "update: " + person)
        (view.listView.adapter as ArrayAdapter<Person>).notifyDataSetChanged()
    }}