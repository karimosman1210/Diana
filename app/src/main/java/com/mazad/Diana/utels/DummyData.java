package com.mazad.Diana.utels;

import com.mazad.Diana.data.CatigoryList;
import com.mazad.Diana.data.Sale_typeResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.PUT;

public class DummyData {
    public static List<String> listSLider() {
        List<String> items = new ArrayList<>();
        items.add("https://currencyshp.com/wp-content/uploads/2019/10/%D8%A7%D8%B1%D9%82%D8%A7%D9%85-%D8%AA%D9%84%D9%8A%D9%81%D9%88%D9%86%D8%A7%D8%AA-%D8%AA%D8%AC%D8%A7%D8%B1-%D8%A7%D9%84%D8%B9%D9%85%D9%84%D8%A7%D8%AA-%D8%A7%D9%84%D9%82%D8%AF%D9%8A%D9%85%D9%87.jpg");
        items.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSPz8WHfQUg715AZWNplABGxjh4B6O9MngPpg&usqp=CAU");
        items.add("https://static.arabic.cnn.com/sites/default/files/styles/sw_780/public/2019/03/04/images/dollar%202%20%20l.jpg?itok=AaFixAjF");

        return items;
    }

    public static List<CatigoryList> listCat() {
        List<CatigoryList> items = new ArrayList<>();
        items.add(new CatigoryList(1, 250, "بنود متاحة للتبادل", ""));
        items.add(new CatigoryList(2, 100, "عملات ورقية متنوعة", ""));
        items.add(new CatigoryList(3, 50, "مجموعة ورقية كاملة", ""));
        items.add(new CatigoryList(4, 20, "إحلال", ""));
        items.add(new CatigoryList(5, 33, " باكو", ""));

        items.add(new CatigoryList(1, 250, "بندل", ""));
        items.add(new CatigoryList(2, 100, "تذكاري", ""));
        items.add(new CatigoryList(3, 50, "مجموعة معدنية كاملة", ""));
        items.add(new CatigoryList(4, 20, "فنتازيا", ""));
        items.add(new CatigoryList(5, 33, " نموذج", ""));
        return items;
    }

    public static List<String> liststring() {
        List<String> items = new ArrayList<>();
        items.add("بنود متاحة للتبادل");
        items.add("بنود متاحة للتبادل");

        return items;
    }

    public static List<Sale_typeResponse> getListType() {
        List<Sale_typeResponse> items = new ArrayList<>();
        items.add(new Sale_typeResponse(1,"جميع المزادات"));
        items.add(new Sale_typeResponse(2,"مزادات جارية"));
        items.add(new Sale_typeResponse(3,"مزادات منتهيه"));
        items.add(new Sale_typeResponse(4,"جميع البيع المباشر"));
        items.add(new Sale_typeResponse(5,"بيع مباشر جاري "));
        items.add(new Sale_typeResponse(6,"بيع مباشر منتهي "));

        return items;

    }


}
