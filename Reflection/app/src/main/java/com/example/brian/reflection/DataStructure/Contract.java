package com.example.brian.reflection.dataStructure;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;


public class Contract {

    //URI cars
    public static final String AUTHORITY = "com.example.brian.reflection";
    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);

    //tables
    public static final String TABLE_REFLECTION    = "reflection";
    public static final String TABLE_PROMPT        = "prompt";

    //inner class for reflections table
    public static final class ReflectionTable implements BaseColumns{
        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(TABLE_REFLECTION).build();

        public static final String COLUMN_REFLECTION_ID = "_id";
        public static final String COLUMN_PROMPT_ID     = "prompt_id";
        public static final String COLUMN_RESPONSE      = "response";
        public static final String COLUMN_ADDED_DATE    = "added_date";

        public static final Uri REFLECTION_URI = BASE_URI.buildUpon().appendPath(TABLE_REFLECTION).build();

        public static final String DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + AUTHORITY
                + "/" + TABLE_REFLECTION;

        public static final String ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + AUTHORITY
                + "/" + TABLE_REFLECTION;

    } //END OF REFLECTION TABLE

    public static final class PromptTable implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(TABLE_PROMPT).build();

        public static final String COLUMN_PROMPT_ID         = "_id";
        public static final String COLUMN_PROMPT            = "prompt";
        public static final String COLUMN_CATEGORY_COLOR    = "color";
        public static final String COLUMN_ACTIVE_YN         = "active_yn";

        public static final Uri PROMPT_URI = BASE_URI.buildUpon().appendPath(TABLE_PROMPT).build();

        public static final String DIR_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + AUTHORITY
                + "/" + TABLE_PROMPT;

        public static final String ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + AUTHORITY
                + "/" + TABLE_PROMPT;

        //builds the URI for a specific movie id
        public static Uri buildPromptURI(long promptId){
            return ContentUris.withAppendedId(PROMPT_URI, promptId);
        }
    } //END OF PROMPT TABLE

}//END OF CONTRACT
