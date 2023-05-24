package com.example.person



import android.widget.TextView
import com.example.person.model.PersonState
import com.example.person.model.PersonViewModel
class TitleController(val view : TitleFragment, val chief : PersonViewModel)  {
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

            this.chief.state.observe(
                context,
                androidx.lifecycle.Observer<PersonState> { state ->
                    if (state != null) {
                        title.text = chief.toString()
                    }
                }
            )
        }
    }
}