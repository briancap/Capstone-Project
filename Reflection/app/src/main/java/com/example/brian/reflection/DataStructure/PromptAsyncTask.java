package com.example.brian.reflection.DataStructure;

import android.os.AsyncTask;

/**
 * Created by Brian on 4/4/2017.
 */

public class PromptAsyncTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        String result = "test";

        return result;
    }

    public void onPostExecute(String result){

    }
}
