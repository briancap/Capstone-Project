package com.example.brian.reflection.dataStructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.brian.reflection.dataStructure.Contract.ReflectionTable;
import com.example.brian.reflection.dataStructure.Contract.PromptTable;

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "refelction.db";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_TABLE_REFLECTIONS =
                "CREATE TABLE IF NOT EXISTS "
                + Contract.TABLE_REFLECTION + " ("
                + ReflectionTable.COLUMN_REFLECTION_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ReflectionTable.COLUMN_PROMPT_ID      + " INTEGER, "
                + ReflectionTable.COLUMN_RESPONSE       + " TEXT NULL, "
                + ReflectionTable.COLUMN_ADDED_DATE     + " TEXT NULL " //TODO: does sqlite have a date data type?
                + " );";

        final String SQL_CREATE_TABLE_PROMPTS =
                "CREATE TABLE IF NOT EXISTS "
                        + Contract.TABLE_PROMPT + " ("
                        + PromptTable.COLUMN_PROMPT_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + PromptTable.COLUMN_PROMPT         + " TEXT NULL, "
                        + PromptTable.COLUMN_CATEGORY_COLOR + " TEXT NULL "
                        + PromptTable.COLUMN_ACTIVE_YN      + " TEXT NULL "
                        + " );";

        db.execSQL(SQL_CREATE_TABLE_REFLECTIONS);
        db.execSQL(SQL_CREATE_TABLE_PROMPTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void dropTable(SQLiteDatabase db, String table){
        db.execSQL("DROP TABLE IF EXISTS " + table);
    }
}
