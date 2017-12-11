package com.memverse.android.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 * @see <a href="https://developer.android.com/training/testing/integration-testing/content-provider-testing.html">Testing your content provider</a>
 */
@RunWith(AndroidJUnit4.class)
public class MemverseContentProviderInstrumentedTest extends ProviderTestCase2<MemverseContentProvider> {

    private static final int NUM_MEMVERSES = 5;

    private ContentResolver mMockResolver;
    private SQLiteDatabase mDb;

    public MemverseContentProviderInstrumentedTest() {
        super(MemverseContentProvider.class, MemverseContract.AUTHORITY);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
        mMockResolver = getMockContentResolver();
        mDb = getProvider().getOpenHelperForTest().getWritableDatabase();
    }

    private void insertData() {
        for (int i = 0; i < NUM_MEMVERSES; i++) {
            ContentValues contentValues = getContentValues(i, i * 3, 100);
            mDb.insertOrThrow(
                    MemverseContract.Memverses.TABLE_NAME,
                    MemverseContract.Memverses.Columns.KEY_EFACTOR, // column to set to null value if values map is empty
                    contentValues
            );
        }
    }

    private ContentValues getContentValues(int id, int verseId, int userId) {
        final ContentValues v = getContentValues(verseId, userId);
        v.put(MemverseContract.Memverses.Columns.KEY_ID, id);
        return v;
    }

    private ContentValues getContentValues(int verseId, int userId) {
        final ContentValues v = new ContentValues();
        v.put(MemverseContract.Memverses.Columns.KEY_VERSE_ID, verseId);
        v.put(MemverseContract.Memverses.Columns.KEY_USER_ID, userId);
        return v;
    }

    @Test
    public void RetrieveAllMemverses() {
        insertData();

        final Cursor cursor = mMockResolver.query(MemverseContract.Memverses.URI, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(NUM_MEMVERSES, cursor.getCount());
    }

    @Test
    public void RetrieveAllMemverses_WhenThereAreNone_DoesNotThrowException() {
        final Cursor cursor = mMockResolver.query(MemverseContract.Memverses.URI, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(0, cursor.getCount());
    }

    @Ignore
    @Test
    public void RetrieveSomeMemversesWithSelectionFilter() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Test
    public void RetrieveSingle() {
        insertData();
        final Uri uri = ContentUris.withAppendedId(MemverseContract.Memverses.URI, 3);

        final Cursor cursor = mMockResolver.query(uri, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(1, cursor.getCount());
    }

    @Test
    public void RetrieveSingle_WhenItDoesNotExist_DoesNotThrowException() {
        insertData();
        final Uri uri = ContentUris.withAppendedId(MemverseContract.Memverses.URI, 20);

        final Cursor cursor = mMockResolver.query(uri, null, null, null, null);

        assertNotNull(cursor);
        assertEquals(0, cursor.getCount());
    }

    @Test
    public void Insert() {
        final Uri resultUri = mMockResolver.insert(MemverseContract.Memverses.URI, getContentValues(40, 50));

        assertEquals(1, ContentUris.parseId(resultUri));
    }

    @Test
    public void Insert_WithAnId_ThrowsException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("KEY_ID not permitted for insert operation");


        mMockResolver.insert(MemverseContract.Memverses.URI, getContentValues(3, 40, 50));
    }

    @Test
    public void Insert_OnUriWithAppendedId_IsNotAllowed() {
        final Uri uri = ContentUris.withAppendedId(MemverseContract.Memverses.URI, 3);
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Operation not supported for this URI");

        mMockResolver.insert(uri, getContentValues(40, 50));
    }

    @Test
    public void Update() {
        insertData();
        final Uri uri = ContentUris.withAppendedId(MemverseContract.Memverses.URI, 3);

        final int numRowsChanged = mMockResolver.update(uri, getContentValues(40, 50), null, null);

        assertEquals(1, numRowsChanged);
    }

    @Test
    public void Update_WhenItDoesNotExist_DoesNotThrowException() {
        final Uri uri = ContentUris.withAppendedId(MemverseContract.Memverses.URI, 20);

        final int numRowsChanged = mMockResolver.update(uri, getContentValues(40, 50), null, null);

        assertEquals(0, numRowsChanged);
    }

    @Test
    public void Update_OnCollectionUri_IsNotAllowed() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Operation not supported for this URI");

        mMockResolver.update(MemverseContract.Memverses.URI, getContentValues(40, 50), null, null);
    }

    @Test
    public void Delete() {
        insertData();
        final Uri uri = ContentUris.withAppendedId(MemverseContract.Memverses.URI, 3);

        final int numRowsChanged = mMockResolver.delete(uri, null, null);

        assertEquals(1, numRowsChanged);
    }

    @Test
    public void Delete_WhenItDoesNotExist_DoesNotThrowException() {
        final Uri uri = ContentUris.withAppendedId(MemverseContract.Memverses.URI, 20);

        final int numRowsChanged = mMockResolver.delete(uri, null, null);

        assertEquals(0, numRowsChanged);
    }

    @Test
    public void Delete_OnCollectionUri_IsNotAllowed() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Operation not supported for this URI");

        mMockResolver.delete(MemverseContract.Memverses.URI, null, null);
    }
}
