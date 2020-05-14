package com.minhphu.basemodule.adapter.diff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.minhphu.basemodule.adapter.BaseViewHolder

abstract class BaseListAdapter<Item, ViewHolder : BaseViewHolder<Item>>(diffCallback: DiffUtil.ItemCallback<Item>)
    : ListAdapter<Item, ViewHolder>(diffCallback) {

    abstract fun getViewHolder(itemView: View): ViewHolder

    @LayoutRes
    abstract fun getLayoutItem(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(getLayoutItem(), parent, false)
        return getViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(item)
        }
    }
}