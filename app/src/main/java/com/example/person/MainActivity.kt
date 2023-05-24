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
import com.example.person.model.Person
import com.example.person.model.Team

class MainActivity : AppCompatActivity() {


    val mea3 = Team("MEA3")
    val mea4 = Team("MEA4")
    val mea5 = Team("MEA5")




    lateinit var listController: ListController
    lateinit var editController: EditController
    lateinit var titleController: TitleController

    lateinit var chief : Person


    var selectedPerson: Person? = null
        set(value) {
            field = value
        }
        get() = field
    var selectedTeam: Team = mea3

    // create a predefined list of persons
    init {

        // add 3 persons in each team
        mea3.addMember(Person("Amine", "Boulouma", "MEA3"))
        mea3.addMember(Person("Paul", "Pogba", "MEA3"))
        var chief1 = Person("Didier", "Deschamps", "MEA3")
        mea3.addMember(chief1)
        mea3.chief = chief1

        mea4.addMember(Person("Kylian", "Mbappé", "MEA4"))
        mea4.addMember(Person("Hugo", "Lloris", "MEA4"))
        var chief2 = Person("Zinedine", "Zidane", "MEA4")
        mea4.addMember(chief2)


        mea5.addMember(Person("Raphaël", "Varane", "MEA5"))
        mea5.addMember(Person("Antoine", "Griezmann", "MEA5"))
        var chief3 = Person("Benjamin", "Pavard", "MEA5")
        mea5.addMember(chief3)

        this.chief = selectedTeam.chief!!

    }

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
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewTitle) as TitleFragment
        )
    }

}