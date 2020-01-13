package com.example.coderpathtodolist.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderpathtodolist.Adapter.todoAdapter
import com.example.coderpathtodolist.Adapter.todoAdapter.onLongClickedListener
import com.example.coderpathtodolist.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var todoList =  mutableListOf<String>()
    lateinit var  myAdapter : todoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadItems()

        val longLickListener = object : onLongClickedListener {
            override fun onItemLongClicked(position: Int) {
                Toast.makeText(applicationContext, "removed ${todoList[position]} to list", Toast.LENGTH_SHORT).show()
                todoList.removeAt(position)
                myAdapter.notifyItemRemoved(position)
                saveItems()

            }
        }
        myAdapter = todoAdapter(this, todoList, longLickListener)
        todoRecyclerView.adapter = myAdapter

        val layoutManager = LinearLayoutManager(this)
        todoRecyclerView.layoutManager = layoutManager
        todoRecyclerView.setHasFixedSize(true)




    }


    fun onAddListItem(view:View){
        if(editListText.text.toString() != "") {
            todoList.add(editListText.text.toString())
            myAdapter.notifyItemInserted(todoList.size-1)
            Toast.makeText(this, "Added ${todoList[todoList.size-1]} to list", Toast.LENGTH_SHORT).show()
            editListText.setText("")
            saveItems()
        }
        else
            Toast.makeText(this,"Please Enter Text", Toast.LENGTH_SHORT).show()
    }
///EASIER TO JUST USE SHARED PREFERENCES

    fun getDataFile(): File {
        // dir of this app , // name of the file
        return File(filesDir, "data.txt")
    }
    fun loadItems(){
        try {
            todoList = ArrayList(org.apache.commons.io.FileUtils.readLines(getDataFile(), Charset.defaultCharset()))
        }catch (e : IOException){
            e.printStackTrace()
            Log.e("ALTIN", "ERROR\n$e")
        }

    }
    fun saveItems(){
        try{
            org.apache.commons.io.FileUtils.writeLines(getDataFile(),todoList)
        }catch (e : IOException){
            e.printStackTrace()
            Log.e("ALTIN", "ERROR\n$e")
        }
    }

}
