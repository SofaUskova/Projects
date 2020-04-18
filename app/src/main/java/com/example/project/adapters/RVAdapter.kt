package com.example.project.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.company.myartist.model.Event
import com.example.project.R

class RVAdapter(
    private val horses: List<Event>,
    private val context: Context
    ) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_horse, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return this.horses.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = horses[position].name
            holder.age.text = horses[position].age

//            holder.cardView.setOnClickListener {
//                context.startActivity(Intent(context, ShowInfoAboutHorse::class.java))
//            }
        }

        inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
            internal val name: TextView = view.findViewById(R.id.name)
            internal val age: TextView = view.findViewById(R.id.age)

            internal val cardView: CardView = view.findViewById(R.id.cardView)
        }
}
