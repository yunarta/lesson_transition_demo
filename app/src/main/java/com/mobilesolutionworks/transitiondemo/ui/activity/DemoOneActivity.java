package com.mobilesolutionworks.transitiondemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobilesolutionworks.transitiondemo.R;
import com.mobilesolutionworks.transitiondemo.ui.fragment.DemoOneSelectionFragment;

/**
 * Created by yunarta on 19/7/15.
 */
public class DemoOneActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);

        if (savedInstanceState == null)
        {
            getFragmentManager().beginTransaction().replace(R.id.fragment_master, new DemoOneSelectionFragment()).commit();
        }
    }
}
