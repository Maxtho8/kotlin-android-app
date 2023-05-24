package com.example.person

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.lifecycle.MutableLiveData
import com.example.person.model.Person
import com.example.person.model.PersonViewModel
import com.example.person.model.Team

class MainActivity : AppCompatActivity() {



    lateinit var listController: ListController
    lateinit var editController: EditController
    lateinit var titleController: TitleController

    lateinit var chief : Person


    var selectedPerson : MutableLiveData<PersonViewModel?>
            = MutableLiveData(null)
    var selectedTeam: Team = Team("Team 1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        // create ListController
        this.listController = ListController(
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewList) as ListFragment,
            selectedTeam.members
        )
        // create EditController
        this.editController = EditController(
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewEditText) as EditTextFragment
        )
        // create TitleController
        this.titleController = TitleController(
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewTitle) as TitleFragment,
            selectedTeam.chief
        )
    }

}