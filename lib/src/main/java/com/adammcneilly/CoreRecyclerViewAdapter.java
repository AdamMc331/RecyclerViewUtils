package com.adammcneilly;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Core class for a RecyclerView.Adapter that displays a list of items of a certain type,
 * with a RecyclerView.ViewHolder used to bind items of that type to a View.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public abstract class CoreRecyclerViewAdapter<T, K extends CoreViewHolder<T>> extends RecyclerView.Adapter<K> implements List<T> {
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

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    @NonNull
    @Override
    public <T1> T1[] toArray(@NonNull T1[] a) {
        return items.toArray(a);
    }

    @Override
    public boolean add(T t) {
        boolean result = items.add(t);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = items.remove(o);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> c) {
        return items.containsAll(c);
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends T> c) {
        boolean result = items.addAll(c);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection<? extends T> c) {
        boolean result = items.addAll(index, c);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> c) {
        boolean result = items.removeAll(c);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> c) {
        boolean result = items.retainAll(c);
        notifyDataSetChanged();
        return result;
    }

    @Override
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }

    @Override
    public T set(int index, T element) {
        T item = items.set(index, element);
        notifyDataSetChanged();
        return item;
    }

    @Override
    public void add(int index, T element) {
        items.add(index, element);
        notifyDataSetChanged();
    }

    @Override
    public T remove(int index) {
        T item = items.remove(index);
        notifyDataSetChanged();
        return item;
    }

    @Override
    public int indexOf(Object o) {
        return items.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return items.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return items.listIterator();
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator(int index) {
        return items.listIterator(index);
    }

    @NonNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return items.subList(fromIndex, toIndex);
    }
}
