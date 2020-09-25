package com.example.music_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Ca_si_adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<List_ca_si> listcasiList;

    public Ca_si_adapter(Context context, int layout, List<List_ca_si> listcasiList) {
        this.context = context;
        this.layout = layout;
        this.listcasiList = listcasiList;
    }
    @Override
    public int getCount() {
        return listcasiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder
    {
        TextView textView_ten;
        TextView textView_chitiet;
        ImageView imageView;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);
            //anhxa
            holder.imageView        = (ImageView)view.findViewById(R.id.imageview1);
            holder.textView_ten     = (TextView)view.findViewById(R.id.text1);
            holder.textView_chitiet = (TextView)view.findViewById(R.id.text2);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        //gan gia tri
        List_ca_si listcasi = listcasiList.get(i);
        holder.textView_ten.setText(listcasi.getName());
        holder.textView_chitiet.setText(listcasi.getChitiet());
        holder.imageView.setImageResource(listcasi.getImage());
        return view;
    }
}
