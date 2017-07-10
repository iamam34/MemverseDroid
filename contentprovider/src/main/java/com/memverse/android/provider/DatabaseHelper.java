package com.memverse.android.provider;

// A string that defines the SQL statement for creating a table

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Helper class that creates and manages the provider's underlying data repository.
 * <p>
 * Created by amy on 7/07/17.
 */
final class DatabaseHelper extends SQLiteOpenHelper {

    DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        // if factory is null, it uses the default SQLite cursor
        super(context, name, factory, version);
    }

    /**
     * Creates the data repository. This is called when the provider attempts to open the
     * repository and SQLite reports that it doesn't exist.
     */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MemverseContract.Memverses.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO do db migration better than destroy and recreate
        db.execSQL(MemverseContract.Memverses.SQL_DELETE_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}


