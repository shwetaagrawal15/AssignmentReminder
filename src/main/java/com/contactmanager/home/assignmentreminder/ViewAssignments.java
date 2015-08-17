//Copyright (c) 2015 Shweta Agrawal 
//This source file is licensed under the "MIT License". 
//Please see the file COPYING in this distribution for license terms.
package com.contactmanager.home.assignmentreminder;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAssignments extends ActionBarActivity {

  //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();
    // defining a custom adapter
    MyCustomAdapter adap = new MyCustomAdapter(listItems,this);

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assignments);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
//        setListAdapter(adapter);


        db.open();
        Cursor c = db.getAllRecords();

//        for (int index=0; index < cursor.getCount(); index++)
//        {
//
//        }

        ListView listView =(ListView)findViewById(R.id.listView);
        c.moveToFirst();


        int counter = 1;
        while(! c.isAfterLast()) {
            String temp="";
            String s1=c.getString(0);
            String s2=c.getString(1);
            String s3=c.getString(2);
            String s4=c.getString(3);
            String s5=c.getString(4);
            temp=temp+"\n"+s2 +"\n"+s3 +"\n"+s4 +"\n"+s5;
            System.out.println(counter + ":::" + temp);

            listItems.add(temp);
            c.moveToNext();
        }

        db.close();


        //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
     //   ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
     //           android.R.layout.simple_list_item_1,
     //           listItems);

       // listView.setAdapter(adapter);
        listView.setAdapter(adap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_assignments, menu);
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

/*@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_assignments);

    //generetae list
    ArrayList<String> list = new ArrayList<String>();
    list.add("item1");
    list.add("item2");

    //instantiate custom adapter
    MyCustomAdapter adapter = new MyCustomAdapter(list,this);
    //handle listview

    ListView lView = (ListView)findViewById(R.id.listView);
    lView.setAdapter(adapter);


}

}
*/
