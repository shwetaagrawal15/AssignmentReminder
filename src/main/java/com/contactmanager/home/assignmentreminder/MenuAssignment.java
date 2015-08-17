//Copyright (c) 2015 Shweta Agrawal 
//This source file is licensed under the "MIT License". 
//Please see the file COPYING in this distribution for license terms.
package com.contactmanager.home.assignmentreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by home on 7/27/2015.
 */

//public class MenuAssignment extends Activity {





public class MenuAssignment extends ActionBarActivity {
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_assignment);

    }
    public void addAssignment(View v)
    {
        Log.d("test", "adding");
        //get data from form
        EditText nameTxt = (EditText)findViewById(R.id.assignText);
        EditText dateTxt = (EditText)findViewById(R.id.dateText);
        EditText courseTxt = (EditText)findViewById(R.id.courseText);
        EditText notesTxt = (EditText)findViewById(R.id.notesText);

        db.open();
        long id = db.insertRecord(nameTxt.getText().toString(), dateTxt.getText().toString(), courseTxt.getText().toString(), notesTxt.getText().toString());
        db.close();

        dateTxt.setText("");
        courseTxt.setText("");
        nameTxt.setText("");
        notesTxt.setText("");
        Toast.makeText(MenuAssignment.this,"Assignment Added", Toast.LENGTH_LONG).show();


    }
    public void viewAssignments(View v)
    {
        Intent i = new Intent(this, ViewAssignments.class);
        startActivity(i);


    }

    public void addReminder(View v)
    {
        Intent i = new Intent(this, TimeReminder.class);
        startActivity(i);
    }

};
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_assignment);
    }
*/
/* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_assignment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/
