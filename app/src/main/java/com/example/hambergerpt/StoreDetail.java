package com.example.hambergerpt;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.hambergerpt.adapters.MenuAdapter;
import com.example.hambergerpt.databinding.ActivityStoreDetailBinding;
import com.example.hambergerpt.datas.HambMenu;
import com.example.hambergerpt.datas.HambergerStores;

import java.util.ArrayList;
import java.util.List;

public class StoreDetail extends BaseActivity {

    ActivityStoreDetailBinding act;
    List<HambMenu> mList = new ArrayList<>();
    HambergerStores hambergerStoresList;
    MenuAdapter menuAdapter;
    HambMenu hambMenuData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        fillMenu();
        setValues();
        setupEvents();

    }


    @Override
    public void setupEvents() {

        act.payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(StoreDetail.this);
                alert.setTitle("결제 확인");
                alert.setMessage("정말 결제하시겠습니까?");
                alert.setPositiveButton("결제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int indexNum = act.menuSpinner.getSelectedItemPosition();
                        HambMenu hambMenuData = mList.get(indexNum);

                        Intent intent = new Intent();
                        intent.putExtra("메뉴정보", hambMenuData);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                });
                alert.setNegativeButton("취소",null);
                alert.show();

            }
        });

    }

    @Override
    public void setValues() {

        menuAdapter = new MenuAdapter(StoreDetail.this, mList);
        act.menuSpinner.setAdapter(menuAdapter);

        hambergerStoresList = (HambergerStores) getIntent().getSerializableExtra("가게정보");

        String imgUri = hambergerStoresList.imgURL;
        int indexNum = act.menuSpinner.getSelectedItemPosition();
        hambMenuData = mList.get(indexNum);


        Glide.with(StoreDetail.this).load(imgUri).into(act.storeImg);
        act.menuNameTxt.setText(hambergerStoresList.storeName);

        int price = hambMenuData.menuPrice;
        menuAdapter.notifyDataSetChanged();
        act.payBtn.setText(String.format("결제하기(%d원)",price));



    }

    @Override
    public void bindViews() {
        act = DataBindingUtil.setContentView(this, R.layout.activity_store_detail);
    }

    public void fillMenu(){

        mList.add(new HambMenu("불고기버거",4500));
        mList.add(new HambMenu("한우버거",6000));
        mList.add(new HambMenu("치즈버거",5000));
        mList.add(new HambMenu("토마토버거",3400));
        mList.add(new HambMenu("불고기버거 세트",6000));
        mList.add(new HambMenu("한우버거 세트",7000));
        mList.add(new HambMenu("콜라",1000));
        mList.add(new HambMenu("감자튀김",2000));

    }


}
