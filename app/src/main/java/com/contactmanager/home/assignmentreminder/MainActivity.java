//Copyright (c) 2015 Shweta Agrawal 
//This source file is licensed under the "MIT License". 
//Please see the file LICENSE in this distribution for license terms.
package com.contactmanager.home.assignmentreminder;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class MainActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, MenuAssignment.class);
                startActivity(i);
            }
        });
        try {
            String destPath = "/data/data/" + getPackageName() +
                    "/databases/AssignmentDB";
            File f = new File(destPath);
            if (!f.exists()) {
                CopyDB(getBaseContext().getAssets().open("mydb"),
                        new FileOutputStream(destPath));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //DBAdapter db = new DBAdapter(this);


        //---add an assignment---
         /*
 db.open();
 long id = db.insertRecord("Hello World", "2/18/2012", "DPR 224", "First Android Project");
 id = db.insertRecord("Workbook Exercises", "3/1/2012", "MAT 100", "Do odd
… numbers");
 db.close();
 */

//---get all Records---
         /*
 db.open();
 Cursor c = db.getAllRecords();
 if (c.moveToFirst())
 {
 do {
 DisplayRecord(c);
 } while (c.moveToNext());
 }
 db.close();
 */

         /*
 //---get a Record---
 db.open();
 Cursor c = db.getRecord(2);
 if (c.moveToFirst())
 DisplayRecord(c);
 else
 Toast.makeText(this, "No Assignments found",
… Toast.LENGTH_LONG).show();
 db.close();
 */

//---update Record---
         /*
 db.open();
 if (db.updateRecord(1, "Hello Android", "2/19/2012", "DPR 224", "First
… Android Project"))
 Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
 else
 Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
 db.close();
 */

         /*
 //---delete a Record---
 db.open();
 if (db.deleteRecord(1))
 Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
 else
 Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
 db.close();
 */
    }


    private class Database extends BaseAdapter {
        private LayoutInflater mInflater;
        //private ArrayList<>

        @Override
        public int getCount() {

            return 0;
        }

        @Override
        public Object getItem(int arg0) {

            return null;
        }

        @Override
        public long getItemId(int arg0) {

            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            return null;
        }

    }

    public void CopyDB(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        //---copy 1K bytes at a time---
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    public void DisplayRecord(Cursor c) {
        Toast.makeText(this, "id: " + c.getString(0) + "\n" +
                        "Title: " + c.getString(1) + "\n" +
                        "Due Date: " + c.getString(2),
                Toast.LENGTH_SHORT).show();
    }

    public void addAssignment(View view) {

        Intent i = new Intent("com.contactmanager.home.Assignmentreminder");
        startActivity(i);
        Log.d("TAG", "Clicked");


    }
}




    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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







/*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
