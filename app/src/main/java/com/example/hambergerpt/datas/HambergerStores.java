package com.example.hambergerpt.datas;

import java.io.Serializable;

public class HambergerStores implements Serializable {

    public String storeName;
    public String location;
    public String openTime;
    public String phoneNum;
    public String imgURL;

    public HambergerStores(String storeName, String location, String openTime, String phoneNum, String imgURL) {
        this.storeName = storeName;
        this.location = location;
        this.openTime = openTime;
        this.phoneNum = phoneNum;
        this.imgURL = imgURL;
    }
}
