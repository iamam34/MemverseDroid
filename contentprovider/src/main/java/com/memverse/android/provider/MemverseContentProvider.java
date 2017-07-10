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

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(MemverseContract.AUTHORITY, MemverseContract.Memverses.TABLE_NAME,
                MemverseContract.Memverses.URI_ALL);
        URI_MATCHER.addURI(MemverseContract.AUTHORITY, MemverseContract.Memverses.TABLE_NAME + "/#",
                MemverseContract.Memverses.URI_SINGLE);
    }

    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    @Override
    public boolean onCreate() {
        mDatabaseHelper = new DatabaseHelper(getContext(), MemverseContract.DATABASE_NAME, null, MemverseContract.DATABASE_VERSION);
        return true;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case MemverseContract.Memverses.URI_ALL:
                return "vnd.android.cursor.dir/vnd." + MemverseContract.AUTHORITY + "." + MemverseContract.Memverses.TABLE_NAME;
            case MemverseContract.Memverses.URI_SINGLE:
                return "vnd.android.cursor.item/vnd." + MemverseContract.AUTHORITY + "." + MemverseContract.Memverses.TABLE_NAME;
            default:
                return null;
        }
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (URI_MATCHER.match(uri)) {
            case MemverseContract.Memverses.URI_ALL:
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = MemverseContract.Memverses.Columns.KEY_ID + " ASC";
                }
                break;
            case MemverseContract.Memverses.URI_SINGLE:
                // append the id path param to the WHERE clause for the query
                // TODO use selectionArgs for _ID
                if (selection == null) {
                    selection = "";
                }
                selection = selection + " " + MemverseContract.Memverses.Columns.KEY_ID + " = " + ContentUris.parseId(uri);
                break;
            default:
                throw new IllegalArgumentException("Unrecognised URI");
        }
        mDatabase = mDatabaseHelper.getReadableDatabase();
        return mDatabase.query(MemverseContract.Memverses.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        // TODO validation
        if (URI_MATCHER.match(uri) != MemverseContract.Memverses.URI_ALL) {
            throw new IllegalArgumentException("Operation not supported for this URI");
        }

        mDatabase = mDatabaseHelper.getWritableDatabase();

        throw new UnsupportedOperationException("Not yet implemented");

        // TODO research nullColumnHack
        // final Uri uri;
        // final long id = mDatabase.insert(DB_TABLE_NAME, null, values);
        // if (id > 0) {
        //      uri = ContentUris.withAppendedId(uri, id);
        //      // if not sync adapter
        //      getContext().getContentResolver().notifyChange(uri, null);
        // } else {
        //      uri = null;
        // }
        // return uri;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO validation
        if (URI_MATCHER.match(uri) != MemverseContract.Memverses.URI_SINGLE) {
            throw new IllegalArgumentException("Operation not supported for this URI");
        }

        mDatabase = mDatabaseHelper.getWritableDatabase();
        return mDatabase.update(MemverseContract.Memverses.TABLE_NAME, values, selection, selectionArgs);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        mDatabase = mDatabaseHelper.getWritableDatabase();
        return mDatabase.delete(MemverseContract.Memverses.TABLE_NAME, selection, selectionArgs);
    }

    /**
     * For tests only
     *
     * @return SQLiteOpenHelper
     * @see <a href="https://android.googlesource.com/platform/development/+/master/samples/NotePad/src/com/example/android/notepad/NotePadProvider.java">Android Notepad sample app</a>
     */
    DatabaseHelper getOpenHelperForTest() {
        return mDatabaseHelper;
    }
}
