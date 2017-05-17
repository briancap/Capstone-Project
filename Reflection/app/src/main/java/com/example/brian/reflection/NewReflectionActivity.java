package com.example.brian.reflection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Brian on 4/4/2017.
 */

public class NewReflectionActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_new_reflection, new NewReflectionFragment())
                .commit();
    }
}
