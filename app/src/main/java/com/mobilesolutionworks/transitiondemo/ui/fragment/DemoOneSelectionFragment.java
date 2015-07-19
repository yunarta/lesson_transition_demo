package com.mobilesolutionworks.transitiondemo.ui.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilesolutionworks.android.compat.ViewBindingAdapter;
import com.mobilesolutionworks.android.compat.ViewBindingHolder;
import com.mobilesolutionworks.transitiondemo.R;
import com.mobilesolutionworks.transitiondemo.ui.binding.CellDemoOneItem;
import com.mobilesolutionworks.transitiondemo.ui.binding.DemoOneSelectionBinder;
import com.squareup.picasso.Picasso;

/**
 * Created by yunarta on 17/7/15.
 */
public class DemoOneSelectionFragment extends Fragment
{
    DemoOneSelectionBinder mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_demo_one_selection, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mBinding.recyclerView.setAdapter(new ViewBindingAdapter()
        {
            @Override
            protected int getItemLayout(int viewType)
            {
                return R.layout.cell_demo_one_item;
            }


            @Override
            public void onBindViewHolder(ViewBindingHolder<? extends ViewDataBinding> holder, int position)
            {
                CellDemoOneItem binding = holder.getBinding();
                binding.setTitle("position " + position);

                Picasso.with(getActivity())
                        .load(R.drawable.android_icon)
                        .into(binding.image);
            }

            @Override
            public ViewBindingHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup parent, int viewType)
            {
                ViewBindingHolder<? extends ViewDataBinding> holder = super.onCreateViewHolder(parent, viewType);
                holder.itemView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        CellDemoOneItem binding = DataBindingUtil.findBinding(v);

//                        ViewGroup group = (ViewGroup) getActivity().findViewById(R.id.container);
//                        TransitionManager.beginDelayedTransition(group);

                        View root = binding.getRoot();
                        binding.image.setTransitionName("transTarget");

                        TransitionInflater ti = TransitionInflater.from(getActivity());
                        setSharedElementReturnTransition(ti.inflateTransition(android.R.transition.explode));
                        setExitTransition(ti.inflateTransition(android.R.transition.explode));

                        Fragment fragment = new DemoOneTransitionFragment();
                        fragment.setSharedElementEnterTransition(ti.inflateTransition(android.R.transition.explode));
                        fragment.setEnterTransition(ti.inflateTransition(android.R.transition.explode));

                        FragmentTransaction ft = getFragmentManager().beginTransaction();

                        ft.addToBackStack(null);
                        ft.addSharedElement(binding.image, "transView");
                        ft.replace(R.id.fragment_container, fragment);
                        ft.commit();
                    }
                });
                return holder;
            }

            @Override
            public int getItemCount()
            {
                return 10;
            }
        });
    }
}
