package com.mobilesolutionworks.transitiondemo.ui.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilesolutionworks.transitiondemo.R;
import com.mobilesolutionworks.transitiondemo.ui.binding.DemoOneTargetBinder;
import com.squareup.picasso.Picasso;

/**
 * Created by yunarta on 19/7/15.
 */
public class DemoOneTransitionFragment extends Fragment
{
    private DemoOneTargetBinder mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_demo_one_target, null, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setTitle("Binder");

        Picasso.with(getActivity()).load(R.drawable.lollipop).into(mBinding.image);
    }
}
