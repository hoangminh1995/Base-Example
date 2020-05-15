package com.minhphu.basemodule.promoteapp

import android.view.View
import com.minhphu.basemodule.R
import com.minhphu.basemodule.adapter.BaseViewHolder
import com.minhphu.basemodule.adapter.normal.BaseAdapter
import com.minhphu.basemodule.extensions.loadImageBase64
import kotlinx.android.synthetic.main.item_app_menu.*

class PromoteAppAdapter(list: List<AppInfo>, private val callback: ListAppMenuCallback) :
    BaseAdapter<AppInfo, PromoteAppAdapter.MenuVH>(list) {

    override fun getLayoutItem(): Int = R.layout.item_app_menu

    override fun getViewHolder(itemView: View): MenuVH = MenuVH(itemView, callback)

    class MenuVH(override val containerView: View, val callback: ListAppMenuCallback) :
        BaseViewHolder<AppInfo>(containerView) {
        override fun bind(item: AppInfo) {
            imgIcon.loadImageBase64(item.base64Image)
            tvAppName.text = item.appName
            containerView.setOnClickListener {
                callback.onClick(item)
            }
        }
    }

    interface ListAppMenuCallback {
        fun onClick(menuUI: AppInfo)
    }
}
