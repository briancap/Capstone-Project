package com.example.brian.reflection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Brian on 4/4/2017.
 */

public class NewReflectionFragment extends Fragment {

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_new_reflection, container, false);

        return rootView;
    }
}
