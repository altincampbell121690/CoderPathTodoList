package com.example.coderpathtodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var todoList: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun onAddListItem(view:View){
        if(editListText.text != null) {
            todoList.add(editListText.text.toString())
            Toast.makeText(this, "item $todoList", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this,"Please Enter Text", Toast.LENGTH_SHORT).show()
    }
}
