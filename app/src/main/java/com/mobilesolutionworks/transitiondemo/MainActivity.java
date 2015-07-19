package com.mobilesolutionworks.transitiondemo;

import android.app.Activity;
import android.os.Bundle;

import com.mobilesolutionworks.transitiondemo.ui.fragment.SelectTestFragment;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        if (savedInstanceState == null)
        {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, new SelectTestFragment()).commit();
        }
    }
}
