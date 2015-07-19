package com.mobilesolutionworks.android.compat;

import android.databinding.BindingAdapter;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;

import com.mobilesolutionworks.android.widget.RecyclerDividerDecoration;

/**
 * Created by yunarta on 19/7/15.
 */
public class RecyclerViewAdapter
{
    @SuppressWarnings("unchecked")
    @BindingAdapter("horizontalDivider")
    public static <T> void horizontalDivider(RecyclerView recyclerView, ColorDrawable drawable)
    {
        recyclerView.addItemDecoration(new RecyclerDividerDecoration(recyclerView.getContext(), RecyclerDividerDecoration.VERTICAL_LIST, drawable));
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter("verticalDivider")
    public static <T> void verticalDivider(RecyclerView recyclerView, ColorDrawable drawable)
    {
        recyclerView.addItemDecoration(new RecyclerDividerDecoration(recyclerView.getContext(), RecyclerDividerDecoration.HORIZONTAL_LIST, drawable));
    }

}
