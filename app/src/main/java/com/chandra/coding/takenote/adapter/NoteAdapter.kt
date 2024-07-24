package com.chandra.coding.takenote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.chandra.coding.takenote.R
import com.chandra.coding.takenote.data.Note
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class NoteAdapter(private var context : Context , private var notes : List<Note>) :
        RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvNoteTitle : MaterialTextView = itemView.findViewById(R.id.tvNoteTitle)
        val tvNoteContent : MaterialTextView = itemView.findViewById(R.id.tvNoteContent)
        val cardView : MaterialCardView = itemView.findViewById(R.id.cardView)


    }

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_home_items , parent , false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder : NoteViewHolder , position : Int) {
        val note = notes[position]
        holder.tvNoteTitle.text = note.title
        holder.tvNoteContent.text = note.content
        if (position % 2 == 0) {
            holder.cardView.setBackgroundColor(
                    ContextCompat.getColor(
                            holder.itemView.context ,
                            R.color.pale_goldenrod
                                          )
                                              )
        } else {
            holder.cardView.setBackgroundColor(ContextCompat.getColor(context , R.color.orchid))
        }

    }


    fun updateData(newData : List<Note>) {
        notes = newData
        notifyDataSetChanged()
    }

    override fun getItemCount() : Int {
        return notes.size
    }
}
