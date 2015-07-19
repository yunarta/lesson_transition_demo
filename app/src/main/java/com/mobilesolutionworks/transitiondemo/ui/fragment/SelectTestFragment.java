package com.mobilesolutionworks.transitiondemo.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilesolutionworks.android.compat.ViewBindingAdapter;
import com.mobilesolutionworks.android.compat.ViewBindingHolder;
import com.mobilesolutionworks.transitiondemo.R;
import com.mobilesolutionworks.transitiondemo.ui.activity.DemoOneActivity;
import com.mobilesolutionworks.transitiondemo.ui.binding.CellTestItem;
import com.mobilesolutionworks.transitiondemo.ui.binding.SelectTestBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunarta on 19/7/15.
 */
public class SelectTestFragment extends Fragment
{
    SelectTestBinder mBinding;

    List<TestItem> mItems;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mItems = new ArrayList<>();
        mItems.add(new TestItem("Master Detail Fragment Transition", "Demonstration of fragment transition for master-detail", DemoOneActivity.class.getName()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_test, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        mBinding.recycler.setLayoutManager(manager);
        mBinding.recycler.setAdapter(new ViewBindingAdapterImpl());
    }

    class TestItem
    {

        public String title;

        public String description;

        public String fragment;

        public TestItem(String title, String description, String fragment)
        {
            this.title = title;
            this.description = description;
            this.fragment = fragment;
        }
    }

    class ViewBindingAdapterImpl extends ViewBindingAdapter
    {
        @Override
        public ViewBindingHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup parent, int viewType)
        {
            ViewBindingHolder<? extends ViewDataBinding> holder = super.onCreateViewHolder(parent, viewType);
            holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    CellTestItem binder = DataBindingUtil.findBinding(view);
                    String fragmentName = binder.getFragment();

                    try
                    {
                        startActivity(new Intent(getActivity(), Class.forName(fragmentName)));
                    }
                    catch (Exception e)
                    {
//                        e.printStackTrace();
                    }
                }
            });
            return holder;
        }

        @Override
        protected int getItemLayout(int viewType)
        {
            return R.layout.cell_test_item;
        }

        @Override
        public void onBindViewHolder(ViewBindingHolder<? extends ViewDataBinding> holder, int position)
        {
            TestItem item = mItems.get(position);

            CellTestItem binding = holder.getBinding();
            binding.setTitle(item.title);
            binding.setDescription(item.description);
            binding.setFragment(item.fragment);
        }


        @Override
        public int getItemCount()
        {
            return mItems.size();
        }

    }

}

