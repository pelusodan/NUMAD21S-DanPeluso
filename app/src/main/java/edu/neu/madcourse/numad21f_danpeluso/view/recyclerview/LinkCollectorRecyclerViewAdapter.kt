package edu.neu.madcourse.numad21f_danpeluso.view.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.neu.madcourse.numad21f_danpeluso.R
import edu.neu.madcourse.numad21f_danpeluso.model.Link
import edu.neu.madcourse.numad21f_danpeluso.view.recyclerview.LinkCollectorRecyclerViewAdapter.*

class LinkCollectorRecyclerViewAdapter(private val links: List<Link>, private val onClick: (String) -> Unit) : RecyclerView.Adapter<LinkCollectorRecyclerViewHolder>() {

    class LinkCollectorRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.link_collector_cell_textview)

        fun bind(link: Link, onClick: (String) -> Unit) {
            textView.text = link.name
            textView.setOnClickListener { onClick(link.url) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkCollectorRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.link_collector_cell, parent, false)
        return LinkCollectorRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = links.size

    override fun onBindViewHolder(holder: LinkCollectorRecyclerViewHolder, position: Int) {
        holder.bind(links[position], onClick)
    }
}