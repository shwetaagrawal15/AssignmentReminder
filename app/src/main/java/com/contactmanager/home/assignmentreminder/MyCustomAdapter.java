//Copyright (c) 2015 Shweta Agrawal 
//This source file is licensed under the "MIT License". 
//Please see the file COPYING in this distribution for license terms.
package com.contactmanager.home.assignmentreminder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by home on 8/6/2015.
 * Copyright (c) 2015 Shweta Agrawal.
 * This source file is licensed under the "MIT License".
 * Please see the COPYING in this distribution for license terms.
 *
 */
public class MyCustomAdapter extends BaseAdapter implements ListAdapter

{
    private ArrayList<String> list=new ArrayList<String>();
    private Context context;
    public MyCustomAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }
@Override
    public int getCount() {
    return list.size();
}
    @Override
    public Object getItem(int pos){
        return list.get(pos);

}
@Override
    public long getItemId(int pos){
    //return list.get(pos).getId();
    return 0;
//return 0 if list donot have Id variable
}
    @Override
    public View getView(final int position,View convertView, ViewGroup parent){
        View view= convertView;
        if (view == null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.delete,null);
        }
        TextView listItemText =(TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));

        Button deleteBtn=(Button)view.findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}





