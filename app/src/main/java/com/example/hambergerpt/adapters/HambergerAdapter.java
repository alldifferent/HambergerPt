package com.example.hambergerpt.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hambergerpt.R;
import com.example.hambergerpt.datas.HambergerStores;

import java.util.List;

public class HambergerAdapter extends ArrayAdapter<HambergerStores> {

    Context mContext;
    List<HambergerStores> mList;
    LayoutInflater inf;

    public HambergerAdapter(Context context, List<HambergerStores> list){

        super(context, R.layout.hamberger_spinner_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.hamberger_list_item, null);
        }

        HambergerStores hambergerData = mList.get(position);

        ImageView storeImg = row.findViewById(R.id.storeImg);
        TextView storeNameTxt = row.findViewById(R.id.storeNameTxt);

        Glide.with(row).load(hambergerData.imgURL).into(storeImg);

        storeNameTxt.setText(hambergerData.storeName);

        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.hamberger_spinner_list_item, null);
        }

        HambergerStores hambergerData = mList.get(position);

        ImageView storeImg = row.findViewById(R.id.storeImg);
        TextView storeNameTxt = row.findViewById(R.id.storeNameTxt);
        TextView locationTxt = row.findViewById(R.id.locationTxt);
        TextView openTimeTxt = row.findViewById(R.id.openTimeTxt);
        TextView phoneNumTxt = row.findViewById(R.id.phoneNumTxt);

        Glide.with(row).load(hambergerData.imgURL).into(storeImg);

        storeNameTxt.setText(hambergerData.storeName);
        locationTxt.setText(String.format("(%s)",hambergerData.location));
        openTimeTxt.setText(String.format("영업시간 - %s",hambergerData.openTime));
        phoneNumTxt.setText(hambergerData.phoneNum);

        return row;
    }
}
