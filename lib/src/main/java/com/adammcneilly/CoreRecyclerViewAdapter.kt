package com.adammcneilly

import android.support.v7.widget.RecyclerView

import kotlin.collections.ArrayList

/**
 * Core class for a RecyclerView.Adapter that displays a list of items of a certain type,
 * with a RecyclerView.ViewHolder used to bind items of that type to a View.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
abstract class CoreRecyclerViewAdapter<T, K : CoreViewHolder<T>>(protected var items: MutableList<T> = ArrayList<T>()) : RecyclerView.Adapter<K>(), MutableList<T> {

    /**
     * Assuming the user is only maintaing one list, return the size of the list.
     * The user can always override this if necessary.
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Assuming the user doesn't need anything fancy, this will automatically bind this item to the given holder.
     * The user can always override this if necessary.
     */
    override fun onBindViewHolder(holder: K, position: Int) {
        holder.bindItem(items[position])
    }

    /**
     * Swaps the current list of items in this adapter with a new list.
     * @param items The new list of items to be displayed.
     */
    fun swapItems(items: MutableList<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    override val size: Int
        get() = items.size

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    override fun add(element: T): Boolean {
        val result = items.add(element)
        notifyItemInserted(items.size - 1)
        return result
    }

    override fun addAll(elements: Collection<T>): Boolean {
        val result = items.addAll(elements)
        notifyDataSetChanged()
        return result
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        val result = items.addAll(index, elements)
        notifyDataSetChanged()
        return result
    }

    override fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun get(index: Int): T {
        return items[index]
    }

    override operator fun set(index: Int, element: T): T {
        val item = items.set(index, element)
        notifyItemChanged(index)
        return item
    }

    override fun add(index: Int, element: T) {
        items.add(index, element)
        notifyItemInserted(index)
    }

    override fun contains(element: T): Boolean {
        return items.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return items.containsAll(elements)
    }

    override fun indexOf(element: T): Int {
        return items.indexOf(element)
    }

    override fun iterator(): MutableIterator<T> {
        return items.iterator()
    }

    override fun lastIndexOf(element: T): Int {
        return items.lastIndexOf(element)
    }

    override fun listIterator(): MutableListIterator<T> {
        return items.listIterator()
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        return items.listIterator(index)
    }

    override fun remove(element: T): Boolean {
        val removed = items.remove(element)
        notifyDataSetChanged()
        return removed
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        val removed = items.removeAll(elements)
        notifyDataSetChanged()
        return removed
    }

    override fun removeAt(index: Int): T {
        val removed = items.removeAt(index)
        notifyItemRemoved(index)
        return removed
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        val retained = items.retainAll(elements)
        notifyDataSetChanged()
        return retained
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        return items.subList(fromIndex, toIndex)
    }
}
