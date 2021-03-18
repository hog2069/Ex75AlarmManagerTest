package com.hog2020.ex75alarmmanagertest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import java.util.Date;

public class AlarmRepeatReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, new Date().toString(), Toast.LENGTH_SHORT).show();

        //15초 후에 재알람
        //다시 알람을 설정
        AlarmManager alarmManager= (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        //15초 후 다시 알람이 시작되도록
        Intent intent2 = new Intent(context,AlarmRepeatReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,20,intent2,PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+15000,pendingIntent);
        }else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+15000,pendingIntent);
        }
    }
}
