package com.example.hambergerpt.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hambergerpt.R;
import com.example.hambergerpt.StoreDetail;
import com.example.hambergerpt.datas.HambMenu;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<HambMenu> {

    Context mContext;
    List<HambMenu> mList;
    LayoutInflater inf;

    public MenuAdapter(Context context, List<HambMenu> list){

        super(context, R.layout.menu_spinner_list_item,list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.menu_spinner_list_item, null);
        }

        HambMenu hambMenuData = mList.get(position);

        TextView menuNameTxt = row.findViewById(R.id.menuNameTxt);
        TextView pirceTxt = row.findViewById(R.id.pirceTxt);

        menuNameTxt.setText(hambMenuData.menuName);
        pirceTxt.setText(String.format("(%s)",hambMenuData.menuPrice));

        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.menu_spinner_list_item, null);
        }

        HambMenu hambMenuData = mList.get(position);

        TextView menuNameTxt = row.findViewById(R.id.menuNameTxt);
        TextView pirceTxt = row.findViewById(R.id.pirceTxt);

        menuNameTxt.setText(hambMenuData.menuName);
        pirceTxt.setText(String.format("(%s)",hambMenuData.menuPrice));

        return row;

    }



}
