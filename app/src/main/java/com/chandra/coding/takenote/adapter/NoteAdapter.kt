package com.chandra.coding.takenote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.data.Note
import com.google.android.material.textview.MaterialTextView

class NoteAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNoteTitle: MaterialTextView = itemView.findViewById(R.id.tvNoteTitle)
        val tvNoteContent: MaterialTextView = itemView.findViewById(R.id.tvNoteContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_home_items, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.tvNoteTitle.text = note.title
        holder.tvNoteContent.text = note.content
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}
