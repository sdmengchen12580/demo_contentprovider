package com.example.yunwen.myselfweblist;

import android.app.Service;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        this.getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, new SmsObserver(new Handler()) {
            @Override
            public boolean deliverSelfNotifications() {
                return super.deliverSelfNotifications();
            }
        });
    }

    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }



    private class SmsObserver extends ContentObserver {
        public SmsObserver(Handler handler) {
            super(handler);
        }
        /**内容改变时候，调用的监听*/
        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Cursor cursor = getContentResolver().query(Uri.parse("content://sms/outbox"), null, null, null, null);
            /**遍历查询得到的结果集，可以获取用户正在发送的短信*/
            while(cursor.moveToNext()){
                StringBuffer sb = new StringBuffer();
                /**获取短信的发送地址*/
                sb.append("address=").append(cursor.getString(cursor.getColumnIndex("address")));
                /**获取短信的标题*/
                sb.append(";subject=").append(cursor.getString(cursor.getColumnIndex("subject")));
                /**获取短信的内容*/
                sb.append("body=").append(cursor.getString(cursor.getColumnIndex("body")));
                /**获取短信的发送时间*/
                sb.append("time=").append(cursor.getString(cursor.getColumnIndex("date")));
                Log.e("———信息内容为———",sb.toString());
            }

        }

    }
}
