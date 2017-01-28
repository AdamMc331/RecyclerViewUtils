package com.adammcneilly;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Core class for a RecyclerView.ViewHolder that displays an object of a given type.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public abstract class CoreViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {
    /**
     * Default constructor.
     */
    public CoreViewHolder(View view) {
        super(view);

        view.setOnClickListener(this);
    }

    /**
     * Binds an object to this ViewHolder's itemView.
     * @param item The item to display in this ViewHolder.
     */
    protected abstract void bindItem(T item);

    /**
     * Called when the list item is clicked.
     */
    @Override
    public void onClick(View v) {

    }
}
