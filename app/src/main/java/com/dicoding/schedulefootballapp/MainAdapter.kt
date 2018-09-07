package com.dicoding.schedulefootballapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.match_detail.view.*
import kotlinx.android.synthetic.main.match_list.view.*

class MainAdapter(private val context: Context, private val events: List<Event>, private val listener: (Event) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.match_list, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(events[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(event: Event, listener: (Event) -> Unit) {

            itemView.date.text = event.dateEvent
            itemView.homeTeam.text = event.strHomeTeam
            itemView.homeScore.text = event.intHomeScore
            itemView.awayTeam.text = event.strAwayTeam
            itemView.awayScore.text = event.intAwayScore
            itemView.setOnClickListener {
                listener(event)
            }

        }
    }
}