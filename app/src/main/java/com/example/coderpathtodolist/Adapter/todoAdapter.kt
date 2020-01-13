package com.example.coderpathtodolist.Adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderpathtodolist.R
import kotlinx.android.synthetic.main.list_item.view.*

class todoAdapter(val context: Context, val todoList : List<String>) : RecyclerView.Adapter<todoAdapter.todoHolder>() {
    inner class todoHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val listItem = itemView.findViewById<TextView>(R.id.listItemtextView)


        fun bindItem(item:String, context: Context){
            listItem.text = item

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoHolder {
       val view = LayoutInflater.from(parent.context).inflate(
           R.layout.list_item,parent, false
       )
        return todoHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: todoHolder, position: Int) {
        holder.bindItem(todoList[position], context)
    }
}