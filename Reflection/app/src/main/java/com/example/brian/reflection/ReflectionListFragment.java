package com.example.brian.reflection;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.res.ConfigurationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brian.reflection.dataStructure.Contract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian on 4/4/2017.
 */

public class ReflectionListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private Uri mUri;
    static Map<Integer, Map<String, Object>> allReflections = new HashMap<>();
    private static final int DETAIL_LOADER = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_reflection_list, container, false);

        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri reflectionUri = Contract.ReflectionTable.CONTENT_URI;

        Loader<Cursor> cursorLoader = new CursorLoader(
                getActivity()
                , reflectionUri
                , null
                , null
                , null
                , null
        );

        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data.getCount() > 1) {
            data.moveToFirst();

            for (int i = 0; i < data.getCount(); i++){ //loops through the cursor and adds the data to a map
                Map<String, Object> singleReflection = new HashMap<>();

                singleReflection.put(Contract.ReflectionTable.COLUMN_REFLECTION_ID
                        , data.getInt(Contract.ReflectionTable.INDEX_REFLECTION_ID));
                singleReflection.put(Contract.ReflectionTable.COLUMN_PROMPT_ID
                        , data.getInt(Contract.ReflectionTable.INDEX_PROMPT_ID));
                singleReflection.put(Contract.ReflectionTable.COLUMN_RESPONSE
                        , data.getString(Contract.ReflectionTable.INDEX_RESPONSE));
                singleReflection.put(Contract.ReflectionTable.COLUMN_ADDED_DATE
                        , data.getString(Contract.ReflectionTable.INDEX_ADDED_DATE));

                allReflections.put(i, singleReflection);

                data.moveToNext();
            }
        }

        //TODO: swap the cursor in the adapter??
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
