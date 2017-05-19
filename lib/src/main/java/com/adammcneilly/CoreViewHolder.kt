package com.adammcneilly

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Core class for a RecyclerView.ViewHolder that displays an object of a given type.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
abstract class CoreViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    init {
        view.setOnClickListener(this)
    }

    /**
     * Binds an object to this ViewHolder's itemView.
     * @param item The item to display in this ViewHolder.
     */
    abstract fun bindItem(item: T)

    /**
     * Called when the list item is clicked.
     *
     * This doesn't have to be overriden because this is abstract, but I did it so the user
     * wouldn't have to if they don't want to use it.
     */
    override fun onClick(v: View) {

    }
}
