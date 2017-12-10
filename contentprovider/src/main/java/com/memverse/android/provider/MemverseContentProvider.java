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

import java.util.Arrays;

public class MemverseContentProvider extends ContentProvider {

    private static final int URI_MATCH_COLLECTION = 8000;
    private static final int URI_MATCH_SINGLE = 8001;

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(MemverseContract.AUTHORITY, MemverseContract.Memverses.TABLE_NAME,
                URI_MATCH_COLLECTION);
        URI_MATCHER.addURI(MemverseContract.AUTHORITY, MemverseContract.Memverses.TABLE_NAME + "/#",
                URI_MATCH_SINGLE);
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
            case URI_MATCH_COLLECTION:
                return "vnd.android.cursor.dir/vnd." + MemverseContract.AUTHORITY + "." + MemverseContract.Memverses.TABLE_NAME;
            case URI_MATCH_SINGLE:
                return "vnd.android.cursor.item/vnd." + MemverseContract.AUTHORITY + "." + MemverseContract.Memverses.TABLE_NAME;
            default:
                return null;
        }
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (URI_MATCHER.match(uri)) {
            case URI_MATCH_COLLECTION:
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = MemverseContract.Memverses.Columns.KEY_ID + " ASC";
                }
                break;
            case URI_MATCH_SINGLE:
                // append the id path param to the WHERE clause for the query
                selection = appendSelectionForId(selection);
                selectionArgs = appendSelectionArgs(selectionArgs, ContentUris.parseId(uri));
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
        if (URI_MATCHER.match(uri) != URI_MATCH_COLLECTION) {
            throw new IllegalArgumentException("Operation not supported for this URI");
        }
        if (values.containsKey(MemverseContract.Memverses.Columns.KEY_ID)) {
            throw new IllegalArgumentException("KEY_ID not permitted for insert operation");
        }

        mDatabase = mDatabaseHelper.getWritableDatabase();

        final long id = mDatabase.insertWithOnConflict(
                MemverseContract.Memverses.TABLE_NAME,
                MemverseContract.Memverses.Columns.KEY_EFACTOR, // column to set to null value if values map is empty
                values,
                SQLiteDatabase.CONFLICT_FAIL
        );
        if (id > 0) {
            uri = ContentUris.withAppendedId(uri, id);
            // TODO if not sync adapter
            getContext().getContentResolver().notifyChange(uri, null);
        } else {
            uri = null;
        }
        return uri;
    }

    /**
     * @param uri           address
     * @param values        data
     * @param selection     parameterised filter
     * @param selectionArgs parameters for selection filter
     * @return the number of rows affected
     */
    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // TODO validation
        if (URI_MATCHER.match(uri) != URI_MATCH_SINGLE) {
            throw new IllegalArgumentException("Operation not supported for this URI");
        }

        // append the id path param to the WHERE clause for the query
        selection = appendSelectionForId(selection);
        selectionArgs = appendSelectionArgs(selectionArgs, ContentUris.parseId(uri));

        mDatabase = mDatabaseHelper.getWritableDatabase();
        return mDatabase.updateWithOnConflict(MemverseContract.Memverses.TABLE_NAME, values, selection, selectionArgs, SQLiteDatabase.CONFLICT_FAIL);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        // TODO validation
        if (URI_MATCHER.match(uri) != URI_MATCH_SINGLE) {
            throw new IllegalArgumentException("Operation not supported for this URI");
        }

        // append the id path param to the WHERE clause for the query
        selection = appendSelectionForId(selection);
        selectionArgs = appendSelectionArgs(selectionArgs, ContentUris.parseId(uri));

        mDatabase = mDatabaseHelper.getWritableDatabase();
        return mDatabase.delete(MemverseContract.Memverses.TABLE_NAME, selection, selectionArgs);
    }

    @NonNull
    private String appendSelectionForId(String selection) {
        final String extension = MemverseContract.Memverses.Columns.KEY_ID + " = ?";
        if (selection == null) {
            return extension;
        } else {
            return selection + " " + extension;
        }
    }

    @NonNull
    private String[] appendSelectionArgs(String[] selectionArgs, long id) {
        if (selectionArgs == null) {
            selectionArgs = new String[]{};
        }
        selectionArgs = Arrays.copyOf(selectionArgs, selectionArgs.length + 1);
        selectionArgs[selectionArgs.length - 1] = Long.toString(id);
        return selectionArgs;
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
