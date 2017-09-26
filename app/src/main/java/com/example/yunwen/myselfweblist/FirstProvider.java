package com.example.yunwen.myselfweblist;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.content.ContentValues.TAG;


public class FirstProvider extends ContentProvider {

    /**第一次创建contentprovider，所调用的方法*/
    @Override
    public boolean onCreate() {
        Log.e(TAG, "onCreate方法被调用 ",null);
        return false;
    }

    /**该刚发的返回值代表该contentprovider所提供数据的MIME类型*/
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    /**查询方法，返回查询得到的Cursor*/
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Log.e(TAG, "（query）查询参数s为："+s,null);
        return null;
    }

    /**该方法返回新插入的记录的uri*/
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.e(TAG, "（insert）查询参数contentValues为："+contentValues,null);
        return null;
    }

    /**实现删除方法，返回被删除的记录条数*/
    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        Log.e(TAG, "（update）查询参数s为："+s,null);
        return 0;
    }

    /**更新方法，返回被更新的记录条数*/
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        Log.e(TAG, "（update）查询参数s为："+s+"       "+ "（contentValues）查询参数contentValues为："+contentValues,null);
        return 0;
    }
}
