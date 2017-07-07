package com.memverse.android.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class MemverseContentProvider extends ContentProvider {

    private static final String AUTHORITY = "com.memverse.android.provider";
    private static final String DB_NAME = "com.memverse.android.provider.database";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE_NAME = "memverses";

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int URI_ALL = 1;
    private static final int URI_SINGLE = 2;

    static {
        URI_MATCHER.addURI(AUTHORITY, DB_TABLE_NAME, URI_ALL);
        URI_MATCHER.addURI(AUTHORITY, DB_TABLE_NAME + "/#", URI_SINGLE);
    }

    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    @Override
    public boolean onCreate() {
        mDatabaseHelper = new DatabaseHelper(getContext(), DB_NAME, null, DB_VERSION, DB_TABLE_NAME);

        return true;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case URI_ALL:
                return "vnd.android.cursor.dir/vnd." + AUTHORITY + "." + DB_TABLE_NAME;
            case URI_SINGLE:
                return "vnd.android.cursor.item/vnd." + AUTHORITY + "." + DB_TABLE_NAME;
            default:
                return null;
        }
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (URI_MATCHER.match(uri)) {
            case URI_ALL:
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = "_ID ASC";
                }
                break;
            case URI_SINGLE:
                // append the id path param to the WHERE clause for the query
                // TODO use selectionArgs for _ID
                selection = selection + "_ID = " + ContentUris.parseId(uri);
                break;
            default:
                throw new IllegalArgumentException("Unrecognised URI");
        }
        mDatabase = mDatabaseHelper.getReadableDatabase();
        return mDatabase.query(DB_TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        // TODO validation
        if (URI_MATCHER.match(uri) != URI_ALL) {
            throw new IllegalArgumentException("Operation not supported for this URI");
        }

        mDatabase = mDatabaseHelper.getWritableDatabase();

        throw new UnsupportedOperationException("Not yet implemented");

        // TODO research nullColumnHack
        // final long id = mDatabase.insert(DB_TABLE_NAME, null, values);
        // return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO validation
        if (URI_MATCHER.match(uri) != URI_SINGLE) {
            throw new IllegalArgumentException("Operation not supported for this URI");
        }

        mDatabase = mDatabaseHelper.getWritableDatabase();
        return mDatabase.update(DB_TABLE_NAME, values, selection, selectionArgs);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        mDatabase = mDatabaseHelper.getWritableDatabase();
        return mDatabase.delete(DB_TABLE_NAME, selection, selectionArgs);
    }
}
