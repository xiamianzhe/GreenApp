package com.example.domain.greenapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domain.greenapp.Dao.LinkMain;
import com.example.domain.greenapp.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter {
    public ListViewAdapter(Context context, int resource, List<LinkMain> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinkMain linkeMain = (LinkMain)getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.listview_item, null);
        final TextView cjtv= (TextView)view.findViewById(R.id.cjtv);
        //ImageView cjiv=(ImageView)view.findViewById(R.id.cjiv);
        cjtv.setText(linkeMain.getCj());
        return view;
    }

}
