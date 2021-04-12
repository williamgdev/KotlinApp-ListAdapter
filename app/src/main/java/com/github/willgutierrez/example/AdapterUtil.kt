package com.github.willgutierrez.example

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

fun listAdapter() = ListAdapter()

class ListAdapter internal constructor() : ListAdapter<Item, RecyclerView.ViewHolder>(itemDiffer) {
    override fun getItemViewType(position: Int): Int = getItem(position).layoutResource

    override fun onCreateViewHolder(parent: ViewGroup, layout: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(parent, layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemViewHolder
        with(getItem(position)) { (holder.itemView as AdapterLayout).bind() }
    }
}

interface Item {
    @get:LayoutRes
    val layoutResource: Int
    val id: Any
    val content: Any?
    fun AdapterLayout.bind()
}

@SuppressLint("ViewConstructor")
class AdapterLayout internal constructor(
        parent: ViewGroup,
        @LayoutRes layoutResource: Int
) : FrameLayout(parent.context) {
    init {
        val child = LayoutInflater.from(parent.context).inflate(layoutResource, parent, false)
        layoutParams = LayoutParams(child.layoutParams.width, child.layoutParams.height)
        addView(child)
    }
}

internal class ItemViewHolder(
        parent: ViewGroup,
        @LayoutRes private val layoutResource: Int
) : RecyclerView.ViewHolder(AdapterLayout(parent, layoutResource))

internal val itemDiffer: DiffUtil.ItemCallback<Item> = object : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(old: Item, new: Item): Boolean = old.id == new.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(old: Item, new: Item): Boolean = old.content == new.content
}