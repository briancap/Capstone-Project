package com.example.brian.reflection.dataStructure;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import timber.log.Timber;

/**
 * Created by Brian on 4/4/2017.
 */

public class Provider extends ContentProvider {

    private static final UriMatcher uriMatcher = matchUri();
    private Database mReflectionDb;
    private static final SQLiteQueryBuilder mQueryBuilder = new SQLiteQueryBuilder();

    //uri ints for matching
    static final int REFLECTION = 100;
    static final int PROMPT     = 200;

    @Override
    public boolean onCreate() {
        mReflectionDb = new Database(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        //cursor for the reflections table
        Cursor cursor = mReflectionDb.getReadableDatabase().query(
                Contract.TABLE_REFLECTION
                , projection
                , selection
                , selectionArgs
                , null
                , null
                , sortOrder
        );

        //for content observer
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = uriMatcher.match(uri);

        if(match == REFLECTION){
            //always going to return more than one reflection so always returning DIR_TYPE
            return Contract.ReflectionTable.DIR_TYPE;
        } else {
            throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = mReflectionDb.getWritableDatabase();
        final int match = uriMatcher.match(uri);
        Uri returnUri = null;

        if(match == REFLECTION){
            //TODO: how does this insert data correctly? column matching?
            long _id = db.insert(Contract.TABLE_REFLECTION, null, values);
            if(_id > 0){
                returnUri = Contract.ReflectionTable.REFLECTION_URI;
            } else {
                throw new android.database.SQLException("*** FAILED TO INSERT ROWS *** " + uri);
            }
        }
        //notify content observers of inserted data
        getContext().getContentResolver().notifyChange(uri, null);
        db.close();
        //TODO: why am i returning this? what is it used for?
        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        //delete favorites when they are unfavorited
        SQLiteDatabase db = mReflectionDb.getWritableDatabase();
        final int match = uriMatcher.match(uri);
        int numRowsDeleted = 0;

        if(selection == null){ selection = "1";} //stealing the Udacity solution to return num rows deleted for all rows

        if(match == REFLECTION){
            db.delete(Contract.TABLE_REFLECTION, selection, selectionArgs);
        }

        if(numRowsDeleted != 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }
        db.close(); // Udacity didn't close the db here for Sushine. oversight? or reason?
        return numRowsDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        //not using this for now
        return 0;
    }

    static UriMatcher matchUri(){

        return null;
    }
}
