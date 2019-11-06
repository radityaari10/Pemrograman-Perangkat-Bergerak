package com.rapandroid.ormawapolines;

import android.content.Intent;

import java.util.ArrayList;

public class HmjData {

    public static String[][] data = new String[][]{
            {"0", "HMJ ELEKTRO", "HMJ Elektro terdiri dari 5 program studi yaitu D3 Teknik Informatika, D3 Teknik Telekomunikasi, D4 Teknik Telekomunikasi, D3 Teknik Listrik, D3 Teknik Elektronika.", "https://i.postimg.cc/QxdcLRBk/hme.jpg"},
            {"1", "HMJ MESIN", "HMJ Elektro terdiri dari 5 program studi yaitu D3 Teknik Informatika, D3 Teknik Telekomunikasi, D4 Teknik Telekomunikasi, D3 Teknik Listrik, D3 Teknik Elektronika.", "https://i.postimg.cc/LsL1BS7R/hmm.jpg"},
            {"2","HMJ SIPIL","HMJ Elektro terdiri dari 5 program studi yaitu D3 Teknik Informatika, D3 Teknik Telekomunikasi, D4 Teknik Telekomunikasi, D3 Teknik Listrik, D3 Teknik Elektronika.", "https://i.postimg.cc/yxBXSxYw/hms.jpg"},
            {"3","HMJ AKUTANSI","HMJ Elektro terdiri dari 5 program studi yaitu D3 Teknik Informatika, D3 Teknik Telekomunikasi, D4 Teknik Telekomunikasi, D3 Teknik Listrik, D3 Teknik Elektronika.", "https://i.postimg.cc/3NS4Jxyj/hmak.jpg"},
            {"4","HMJ ADMINISTRASI BISNIS","HMJ elektro terdiri dari 5 program studi yaitu D3 Teknik Informatika ", "https://i.postimg.cc/pLYvD1Z4/hmab.jpg"}
    };

    public static ArrayList<Hmj> getListData(){
        ArrayList<Hmj> list = new ArrayList<>();
        for (String[] aData: data){
            Hmj hmj = new Hmj();
            hmj.setId(Integer.parseInt(aData[0]));
            hmj.setName(aData[1]);
            hmj.setDescription(aData[2]);
            hmj.setPhoto(aData[3]);

            list.add(hmj);
        }
        return list;
    }
}
