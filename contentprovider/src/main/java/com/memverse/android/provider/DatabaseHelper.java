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

    private final String tableName;

    DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, String tableName) {
        // if factory is null, it uses the default SQLite cursor
        super(context, name, factory, version);
        this.tableName = tableName;
    }

    /**
     * Creates the data repository. This is called when the provider attempts to open the
     * repository and SQLite reports that it doesn't exist.
     */
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " +
                tableName + " " +
                "(" +                           // FIXME The columns in the table
                " _ID INTEGER PRIMARY KEY, " +
//                " WORD TEXT" +
//                " FREQUENCY INTEGER " +
//                " LOCALE TEXT " +
                ")";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // TODO: Handle database upgrades
        throw new UnsupportedOperationException();
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // TODO: Handle database downgrades
        throw new UnsupportedOperationException();
    }

}


