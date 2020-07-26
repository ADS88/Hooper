package com.android.example.hooper.screens.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.hooper.R
import com.android.example.hooper.database.Game

class GameAdapter: RecyclerView.Adapter<GameAdapter.ViewHolder>(){
    var data = listOf<Game>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = data[position]
        holder.teamOneName.text = game.teamOneName
        holder.teamOneScore.text = game.teamOneScore.toString()
        holder.teamTwoName.text = game.teamTwoName
        holder.teamTwoScore.text = game.teamTwoScore.toString()
        holder.gameDate.text = game.gameDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_item_game, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val teamOneScore: TextView = itemView.findViewById(R.id.team_one_score)
        val teamOneName: TextView = itemView.findViewById(R.id.team_one_name)
        val teamTwoScore: TextView = itemView.findViewById(R.id.team_two_score)
        val teamTwoName: TextView = itemView.findViewById(R.id.team_two_name)
        val gameDate: TextView = itemView.findViewById(R.id.game_date)
    }
}