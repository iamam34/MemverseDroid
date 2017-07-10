package com.memverse.android.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 * @see <a href="https://developer.android.com/training/testing/integration-testing/content-provider-testing.html">Testing your content provider</a>
 */
@RunWith(AndroidJUnit4.class)
public class MemverseContentProviderInstrumentedTest extends ProviderTestCase2<MemverseContentProvider> {

    private ContentResolver mMockResolver;
    private SQLiteDatabase mDb;

    public MemverseContentProviderInstrumentedTest() {
        super(MemverseContentProvider.class, MemverseContract.AUTHORITY);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
        mMockResolver = getMockContentResolver();
        mDb = getProvider().getOpenHelperForTest().getWritableDatabase();
    }

    private void insertData(int numMemverses) {
        for (int i = 0; i < numMemverses; i++) {
            ContentValues contentValues = getContentValues(i, i * 3, 100);
            mDb.insertOrThrow(
                    MemverseContract.Memverses.TABLE_NAME,
                    MemverseContract.Memverses.Columns.KEY_EFACTOR, // column to set to null value if values map is empty
                    contentValues
            );
        }
    }

    private ContentValues getContentValues(int id, int verseId, int userId) {
        ContentValues v = new ContentValues();
        v.put(MemverseContract.Memverses.Columns.KEY_ID, id);
        v.put(MemverseContract.Memverses.Columns.KEY_VERSE_ID, verseId);
        v.put(MemverseContract.Memverses.Columns.KEY_USER_ID, userId);
        return v;
    }

    @Test
    public void canRetrieveAllMemverses() {
        final int NUM_MEMVERSES = 5;
        final Uri uri = Uri.parse("content://" + MemverseContract.AUTHORITY + "/" + MemverseContract.Memverses.TABLE_NAME);
        insertData(NUM_MEMVERSES);

        final Cursor cursor = mMockResolver.query(uri, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(NUM_MEMVERSES, cursor.getCount());
    }

    @Test
    public void canRetrieveAllMemversesWhenThereAreNone() {
        final Uri uri = Uri.parse("content://" + MemverseContract.AUTHORITY + "/" + MemverseContract.Memverses.TABLE_NAME);

        final Cursor cursor = mMockResolver.query(uri, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(0, cursor.getCount());
    }

    @Ignore
    @Test
    public void canRetrieveMemversesWithSelectionFilter() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Test
    public void canRetrieveSingleMemverse() {
        final int NUM_MEMVERSES = 5;
        final int id = 3;
        final Uri uri = Uri.parse("content://" + MemverseContract.AUTHORITY + "/" + MemverseContract.Memverses.TABLE_NAME + "/" + id);
        insertData(NUM_MEMVERSES);

        final Cursor cursor = mMockResolver.query(uri, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(1, cursor.getCount());
    }

    @Test
    public void cannotRetrieveSingleMemverseThatDoesNotExist() {
        final int id = 40;
        final Uri uri = Uri.parse("content://" + MemverseContract.AUTHORITY + "/" + MemverseContract.Memverses.TABLE_NAME + "/" + id);
        insertData(5);

        final Cursor cursor = mMockResolver.query(uri, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(0, cursor.getCount());

        cursor.close();
    }

    @Ignore
    @Test
    public void canInsertMemverse() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void cannotInsertMemverseThatAlreadyExists() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void cannotInsertOnUriWithAppendedId() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void canUpdateMemverse() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void cannotUpdateMemverseThatDoesNotExist() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void cannotUpdateOnCollectionUri() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void canDeleteMemverse() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void cannotDeleteMemverseThatDoesNotExist() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Ignore
    @Test
    public void cannotDeleteOnCollectionUri() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
