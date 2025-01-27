package com.minhphu.basemodule.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<Item>(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    abstract fun bind(item: Item)
}