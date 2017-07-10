package com.memverse.android.provider;

import android.text.TextUtils;

/**
 * Defines constants for the Memverse ContentProvider and its database.
 * Created by amy on 10/07/17.
 */

final class MemverseContract {

    private MemverseContract() {
    } // disallow instantiation

    static final String AUTHORITY = "com.memverse.android.provider";
    static final String DATABASE_NAME = AUTHORITY + ".database";
    static final int DATABASE_VERSION = 1;

    static final class Memverses {
        static final String TABLE_NAME = "memverses";

        static final int URI_ALL = 8000;
        static final int URI_SINGLE = 8001;

        static final String SQL_CREATE_TABLE = TextUtils.join(" ", new String[]{
                "CREATE TABLE IF NOT EXISTS", TABLE_NAME, "(",
                Columns.KEY_ID, "INTEGER PRIMARY KEY,", // TODO check compatibility with BaseColumns._ID
                Columns.KEY_VERSE_ID, "INTEGER NOT NULL,",
                Columns.KEY_USER_ID, "INTEGER NOT NULL,",
                Columns.KEY_EFACTOR, "NUMERIC,",
                Columns.KEY_TEST_INTERVAL, "INTEGER,",
                Columns.KEY_REP_N, "INTEGER,",
                Columns.KEY_NEXT_TEST, "DATE,",
                Columns.KEY_STATUS, "STRING,",
                Columns.KEY_PREV_VERSE, "INTEGER,",
                Columns.KEY_REF_INTERVAL, "INTEGER,",
                Columns.KEY_NEXT_REF_TEST, "DATE,",
                Columns.KEY_PASSAGE_ID, "INTEGER,",
                Columns.KEY_SUBSECTION, "INTEGER", // no trailing comma
                ");"
        });
        static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        static final String[] COLUMN_KEYS = new String[]{
                Columns.KEY_ID,
                Columns.KEY_VERSE_ID,
                Columns.KEY_USER_ID,
                Columns.KEY_EFACTOR,
                Columns.KEY_TEST_INTERVAL,
                Columns.KEY_REP_N,
                Columns.KEY_NEXT_TEST,
                Columns.KEY_STATUS,
                Columns.KEY_PREV_VERSE,
                Columns.KEY_REF_INTERVAL,
                Columns.KEY_NEXT_REF_TEST,
                Columns.KEY_PASSAGE_ID,
                Columns.KEY_SUBSECTION
        };

        interface Columns {
            String KEY_ID = "id";
            String KEY_VERSE_ID = "verse_id";
            String KEY_USER_ID = "user_id";
            String KEY_EFACTOR = "efactor";
            String KEY_TEST_INTERVAL = "test_interval";
            String KEY_REP_N = "rep_n";
            String KEY_NEXT_TEST = "next_test";
            String KEY_STATUS = "status";
            String KEY_PREV_VERSE = "prev_verse";
            String KEY_REF_INTERVAL = "ref_interval";
            String KEY_NEXT_REF_TEST = "next_ref_test";
            String KEY_PASSAGE_ID = "passage_id";
            String KEY_SUBSECTION = "subsection";
        }
    }
}
