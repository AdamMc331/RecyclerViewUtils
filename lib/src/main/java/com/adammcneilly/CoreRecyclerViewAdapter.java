package com.adammcneilly;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Core class for a RecyclerView.Adapter that displays a list of items of a certain type,
 * with a RecyclerView.ViewHolder used to bind items of that type to a View.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public abstract class CoreRecyclerViewAdapter<T, K extends CoreViewHolder<T>> extends RecyclerView.Adapter<K>{
    /**
     * The items to be displayed in this adapter.
     */
    private List<T> items;

    public CoreRecyclerViewAdapter() {
        this.items = new ArrayList<>();
    }

    public CoreRecyclerViewAdapter(List<T> items) {
        this.items = items;
    }

    /**
     * Assuming the user is only maintaing one list, return the size of the list.
     * The user can always override this if necessary.
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Assuming the user doesn't need anything fancy, this will automatically bind this item to the given holder.
     * The user can always override this if necessary.
     */
    @Override
    public void onBindViewHolder(K holder, int position) {
        holder.bindItem(items.get(position));
    }

    /**
     * Swaps the current list of items in this adapter with a new list.
     * @param items The new list of items to be displayed.
     */
    public void swapItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    /**
     * Adds a new item to the adapter's list.
     * @param item The item to insert into the list.
     */
    public void add(T item) {
        if(items.add(item)) {
            // We don't have an index, so just call notifyDataSetChanged
            notifyDataSetChanged();
        }
    }

    /**
     * Adds a new item to the adapter's list.
     * @param position The position to insert the new item.
     * @param item The item to insert into the list.
     */
    public void add(int position, T item) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    /**
     * Removes an item from the list at a given position.
     * @param position The position of the item to remove.
     */
    public T remove(int position) {
        T removed = items.remove(position);
        notifyItemRemoved(position);
        return removed;
    }

    /**
     * Removes a specific item from the list.
     * @param item The item to be removed.
     */
    public void remove(T item) {
        if(items.remove(item)) {
            // We don't have an index, so just call notifyDataSetChanged
            notifyDataSetChanged();
        }
    }
}
