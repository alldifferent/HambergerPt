package com.example.hambergerpt.datas;

import java.io.Serializable;

public class HambMenu implements Serializable {

   public String menuName;
   public int menuPrice;

    public HambMenu(String menuName, int menuPrice) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }
}
