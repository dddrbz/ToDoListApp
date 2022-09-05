package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoAdapter = ToDoAdapter(mutableListOf())

        rvToDoItems.adapter = toDoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val toDoNote = etToDoNote.text.toString()
            if (toDoNote.isNotEmpty()) {
                val toDo = ToDo(toDoNote)
                toDoAdapter.addToDo(toDo)
                etToDoNote.text.clear()
            }
        }
        btnDeleteToDo.setOnClickListener {
            toDoAdapter.deleteToDo()
        }
    }
}