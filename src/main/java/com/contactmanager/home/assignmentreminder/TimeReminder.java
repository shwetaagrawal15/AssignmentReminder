package com.contactmanager.home.assignmentreminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;


public class TimeReminder extends ActionBarActivity {

        AlarmManager alarmManager;
        private PendingIntent pendingIntent;
        private TimePicker alarmTimePicker;
        private static TimeReminder inst;
        private TextView alarmTextView;

        public static TimeReminder instance() {
            return inst;
        }

        @Override
        public void onStart() {
            super.onStart();
            inst = this;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_time_reminder);
            alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
            alarmTextView = (TextView) findViewById(R.id.alarmText);
            ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        }

        public void onToggleClicked(View view) {
            if (((ToggleButton) view).isChecked()) {
                Log.d("TimeReminder", "Alarm On");
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                Intent myIntent = new Intent(TimeReminder.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(TimeReminder.this, 0, myIntent, 0);
                alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            } else {
                //AlarmReceiver.stopRingtone();
                AlarmReceiver.stopRingtone();
                alarmManager.cancel(pendingIntent);
                setAlarmText("");
                Log.d("TimeReminder", "Alarm Off");
            }
        }

        public void setAlarmText(String alarmText) {
            alarmTextView.setText(alarmText);
        }
}

