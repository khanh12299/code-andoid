package com.example.music_listview;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Bai_hat_Adapter extends BaseAdapter
{
     private Context context;
     private int layout;
     private List<List_bai_hat> listbaihat;

    public Bai_hat_Adapter(Context context, int layout, List<List_bai_hat> listbaihat) {
        this.context = context;
        this.layout = layout;
        this.listbaihat = listbaihat;
    }

    @Override
    public int getCount() {
        return listbaihat.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout,null);

        //anhxa
        TextView textView_casi = (TextView) view.findViewById(R.id.text1);
        EditText editText_ten  = (EditText) view.findViewById(R.id.edittex1);

        //gan gia tri
        List_bai_hat list_bai_hat = listbaihat.get(i);
        textView_casi.setText(list_bai_hat.getTenbaihat());
        editText_ten.setText(list_bai_hat.getFile());
        return view;
    }
}
