package com.example.exercise1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Listviewadapter<view> extends BaseAdapter {

    Context mContext;

    LayoutInflater Inflater;

    private ArrayList<Nama> arrayList;

    public  Listviewadapter(Context context ) {
        mContext = context;

        Inflater = LayoutInflater.from(mContext);

        this.arrayList = new ArrayList<Nama>();

        this.arrayList.addAll(HomeActivity.classNamaArrayList);
    }
    public class ViewHolder {

        TextView name;
    }


    @Override
    public int getCount() {
        return HomeActivity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return HomeActivity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();

            view = Inflater.inflate(R.layout.item_listview, null);

            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getNama());


        return view;
    }
}