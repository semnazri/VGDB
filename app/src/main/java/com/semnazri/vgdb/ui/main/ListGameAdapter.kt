package com.semnazri.vgdb.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.semnazri.vgdb.R
import com.semnazri.vgdb.model.list.ResultsItem
import kotlinx.android.synthetic.main.item_content.view.*

class ListGameAdapter(private val onItemClicked: (ResultsItem) -> Unit) :
    RecyclerView.Adapter<ListGameAdapter.ViewHolder>() {

    var items = mutableListOf<ResultsItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun addItems(searchItems: List<ResultsItem>) {
        items.addAll(searchItems)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(contents: ResultsItem, onItemClicked: (ResultsItem) -> Unit) {
            itemView.apply {
                Glide.with(this).load(contents.backgroundImage).into(item_img_content)
                item_game_title.text = contents.name
                item_release_date.text = resources.getString(R.string.releaseDate, contents.released)
                item_game_rating.text = contents.rating.toString()
                setOnClickListener { onItemClicked.invoke(contents) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]
        holder.bindData(data, onItemClicked)
    }
}