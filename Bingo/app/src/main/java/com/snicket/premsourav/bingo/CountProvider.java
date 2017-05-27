package com.snicket.premsourav.bingo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Prem Sourav on 06-04-2017.
 */

public class CountProvider extends ContentProvider {
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String q="select * from cou";
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("countdb",c.MODE_PRIVATE,null);
        Cursor cur=db.rawQuery(q,null);
        return cur;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        String info="THIS IS COUNTER : READ ONLY";
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
