package com.hog2020.ex75alarmmanagertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


//리시버는 반드시 메니페스트에 등록
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //리시버가 알람 방송을 들으면... 새로운 액티비티를 보여주기

        Intent intent1= new Intent(context,AlarmActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
