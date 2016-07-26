package com.adammcneilly.recyclerviewutils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Core class for a RecyclerView.ViewHolder that displays an object of a given type.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public abstract class CoreViewHolder<T> extends RecyclerView.ViewHolder {
    /**
     * Default constructor.
     */
    public CoreViewHolder(View view) {
        super(view);
    }

    /**
     * Binds an object to this ViewHolder's itemView.
     * @param item The item to display in this ViewHolder.
     */
    protected abstract void bindItem(T item);
}
