package com.android.example.hooper.screens.history

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.hooper.R
import com.android.example.hooper.TextItemViewHolder
import com.android.example.hooper.database.Game

class GameAdapter: RecyclerView.Adapter<TextItemViewHolder>(){
    var data = listOf<Game>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val game = data[position]
        holder.textView.text = game.teamOneName + " VS " + game.teamTwoName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}