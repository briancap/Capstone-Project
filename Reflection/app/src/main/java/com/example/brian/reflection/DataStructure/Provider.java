package com.example.brian.reflection.dataStructure;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Brian on 4/4/2017.
 */

public class Provider extends ContentProvider {

    private static final UriMatcher uriMatcher = matchUri();
    private Database mReflectionDb;
    private static final SQLiteQueryBuilder mQueryBuilder = new SQLiteQueryBuilder();

    static final int REFLECTION = 100;

    @Override
    public boolean onCreate() {
        mReflectionDb = new Database(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String tableName;
        Cursor cursor;


        cursor = mReflectionDb.getReadableDatabase().query(
                Contract.TABLE_REFLECTION
                , projection
                , selection
                , selectionArgs
                , null
                , null
                , sortOrder
        );

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    static UriMatcher matchUri(){

        return null;
    }
}
