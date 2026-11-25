package com.google.android.apps.wallpaper.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;


public class RecentWallpapersProvider extends ContentProvider {

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/recent_wallpapers";
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String path = uri.getPath();
        if (path == null || !path.startsWith("/list_recent")) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"id", "placeholder_color", "component", "title"});
        matrixCursor.addRow(new Object[]{"d4rk_current", 0xFF202124, "", ""});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!"/set_recent_wallpaper".equals(uri.getPath())) {
            return 0;
        }
        return 1;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }
}
