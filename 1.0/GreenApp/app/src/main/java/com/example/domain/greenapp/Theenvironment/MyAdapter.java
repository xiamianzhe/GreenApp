//package com.example.domain.greenapp.Theenvironment;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import com.example.domain.greenapp.R;
//
//import java.util.List;
//
//public class MyAdapter extends ArrayAdapter {
//    public MyAdapter(Context context, int resource, List<LinkMain> objects) {
//        super(context, resource, objects);
//    }
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LinkMain linkeMain = (LinkMain)getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.listview_item, null);
//        final TextView cj= (TextView)view.findViewById(R.id.cj);
//        cj.setText(linkeMain.getCj());
//        return view;
//    }
//}
