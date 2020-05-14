package com.minhphu.basemodule.adapter.normal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.minhphu.basemodule.adapter.BaseViewHolder

abstract class BaseAdapter<Item, ViewHolder : BaseViewHolder<Item>>(var items: List<Item>) : RecyclerView.Adapter<ViewHolder>() {

    abstract fun getViewHolder(itemView: View): ViewHolder

    override fun getItemCount(): Int = items.size

    @LayoutRes
    abstract fun getLayoutItem(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(getLayoutItem(), parent, false)
        return getViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}