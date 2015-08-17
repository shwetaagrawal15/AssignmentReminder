//Copyright (c) 2015 Shweta Agrawal 
//This source file is licensed under the "MIT License".
//Please see the file COPYING in this distribution for license terms.
package com.contactmanager.home.assignmentreminder;

/**
 * Created by home on 7/29/

 */
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlarmReceiver extends WakefulBroadcastReceiver {


    private static Ringtone mRingtone = null;
    @Override
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message
        TimeReminder inst = TimeReminder.instance();
        inst.setAlarmText("Alarm!!! Assignment Start");

        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        mRingtone = RingtoneManager.getRingtone(context, alarmUri);
        mRingtone.play();

        //this will send a notification message
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }

    public static void stopRingtone()

    {
        mRingtone.stop();

    }
}
