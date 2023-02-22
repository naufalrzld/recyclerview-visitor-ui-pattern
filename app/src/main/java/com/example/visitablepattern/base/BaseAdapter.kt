package com.example.visitablepattern.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.visitablepattern.ui.adapter.VisitorElement

class BaseAdapter constructor(
    private val viewTypeElement: VisitorElement,
    private val items: ArrayList<VisitorUIModel> = arrayListOf()
) : RecyclerView.Adapter<AbstractViewHolder<VisitorUIModel>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbstractViewHolder<VisitorUIModel> {
        val layoutView = LayoutInflater.from(parent.context).inflate(
            viewType,
            parent,
            false
        )
        return viewTypeElement.createViewHolder(layoutView, viewType) as AbstractViewHolder<VisitorUIModel>
    }

    override fun onBindViewHolder(holder: AbstractViewHolder<VisitorUIModel>, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return items[position].type(viewTypeElement)
    }

    fun addItem(item: VisitorUIModel) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    fun addItems(item: List<VisitorUIModel>) {
        this.items.addAll(item)
        notifyDataSetChanged()
    }
}