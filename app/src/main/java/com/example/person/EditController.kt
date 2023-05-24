package com.example.person


import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import com.example.person.model.Person
import java.util.ArrayList
import java.util.Observable
import java.util.Observer

class EditController(val view : EditTextFragment)  {
    lateinit var context: MainActivity

    lateinit var textInput: EditText

    init {
        this.context = view.activity as MainActivity
        if (context == null) {
            println("context is null")
        } else {
            println("context is not null")

            this.textInput = view.editText
            textInput.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    print(v.text.toString())
                    context.selectedPerson?.firstname = v.text.toString()
                    v.text = ""
                    true

                } else {
                    false
                }
            }
            textInput.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {

                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence,
                    start: Int, before: Int, count: Int
                ) {
                }
            })

        }

    }
}