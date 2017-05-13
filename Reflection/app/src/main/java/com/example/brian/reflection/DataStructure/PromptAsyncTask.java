package com.example.brian.reflection.dataStructure;

import android.database.Cursor;
import android.os.AsyncTask;

/**
 * Created by Brian on 4/4/2017.
 */

public class PromptAsyncTask extends AsyncTask<Void, Void, Cursor> {
    private Database mPromptdb;

    @Override
    protected Cursor doInBackground(Void... params) {
        Cursor result;

        //TODO: default to returning all. will have to define a counter to loop through a single prompt at a time
        result = mPromptdb.getReadableDatabase().query(
                Contract.TABLE_PROMPT
                , null
                , null
                , null
                , null
                , null
                , null
        );

        return result;
    }

    public void onPostExecute(Cursor result){
        //TODO: need to return the result to the PromtAndSettingsActity in some way
    }
}
