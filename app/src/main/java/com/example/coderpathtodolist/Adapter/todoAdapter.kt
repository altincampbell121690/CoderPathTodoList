package com.example.coderpathtodolist.Adapter

import android.content.Context
import android.view.ContextMenu
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class todoAdapter(val context: Context, val todoList : List<String>) : RecyclerView.Adapter<todoAdapter.todoHolder>() {
    inner class todoHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: todoHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}