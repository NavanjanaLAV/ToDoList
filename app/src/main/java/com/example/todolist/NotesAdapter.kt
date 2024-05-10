package com.example.todolist


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater


class NotesAdapter(private var notes:List<Note>, context:Context) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){

    class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleView: TextView = itemView.findViewById(R.id.title)
        val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notes[position]
        holder.titleView.text = note.title
        holder.contentTextView.text = note.content
    }

    fun freshData(newNotes: List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }
}