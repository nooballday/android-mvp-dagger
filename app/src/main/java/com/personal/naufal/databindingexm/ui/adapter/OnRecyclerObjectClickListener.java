package com.personal.naufal.databindingexm.ui.adapter;

/**
 * Created by Naufal on 03/02/2018.
 */

public interface OnRecyclerObjectClickListener<T> extends BaseRecyclerListener {
    void onItemClicked(T item);
}
