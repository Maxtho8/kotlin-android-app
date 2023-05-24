package com.example.person

import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData
import com.example.person.model.Person
import com.example.person.model.PersonState
import com.example.person.model.PersonViewModel
import java.util.ArrayList
import java.util.Observable
import java.util.Observer

class ListController(val view : ListFragment, var list: MutableList<PersonViewModel>) {
    lateinit var context: MainActivity

    init {
        this.context = view.activity as MainActivity
        if (context == null) {
            println("context is null")
        } else {
            println("context is not null")
            val adapter = ArrayAdapter<PersonViewModel>(
                context,
                android.R.layout.simple_list_item_1,
                list
            )
            view.listView.adapter = adapter
            view.listView.setOnItemClickListener { parent, view, position, id ->
                onClickItem(position)
            }

            for (person in list) {
                person.state.observe(
                    context,
                    androidx.lifecycle.Observer<PersonState> { state ->
                        if (state != null) {
                            adapter.notifyDataSetChanged()
                        }
                    }
                )
            }
        }
    }

    fun onClickItem(index: Int) {
        val person = list[index]
        context.selectedPerson = MutableLiveData(person)
        context.editController.textInput.setText(person.firstname)
    }
}
