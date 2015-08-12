package com.contactmanager.home.assignmentreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


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
/*        try {
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
*/

    }

}
  /*  private class Database extends BaseAdapter {
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

    @Override    public boolean onOptionsItemSelected(MenuItem item) {
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