package com.example.visitablepattern.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractViewHolder<in T>(
    view: View
) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(data: T)
}