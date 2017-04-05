package com.example.brian.reflection.DataStructure;

import android.net.Uri;
import android.provider.BaseColumns;


public class Contract {

    public static final String AUTHORITY = "com.example.brian.reflection";
    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);

    public static final String refltionTableName    = "reflection";
    public static final String promptTableName      = "prompt";


    public static final class ReflectionTable implements BaseColumns{

        public static final String COLUMN_ID_AI = "_id";
        public static final String


    }







}
