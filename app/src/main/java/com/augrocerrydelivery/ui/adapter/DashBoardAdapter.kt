package com.augrocerrydelivery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.augrocerrydelivery.R

class DashBoardAdapter : RecyclerView.Adapter<DashBoardAdapter.EventViewHolder>() {
    val eventList = listOf("0", "1", "2")

    // Layout "layout_demo_viewpager2_cell.xml" will be defined later
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EventViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dashboard_viewpager_item,
                parent,
                false
            )
        )

    override fun getItemCount() = eventList.count()
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        when (eventList[position]) {
            "0" ->
                holder.textViewViwPager.text = "New Order"

            "1" ->
                holder.textViewViwPager.text = "In Process"


            "2" ->
                holder.textViewViwPager.text = "Order History"

        }

    }

    class EventViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textViewViwPager = view.findViewById<TextView>(R.id.textViewViwPager)
    }
}