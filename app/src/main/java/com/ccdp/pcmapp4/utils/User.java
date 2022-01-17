package com.ccdp.pcmapp4.utils;

/**
 * Created by Susi on 10/8/2018.
 */

public class User{
    private String name;
    private String phonenumber;

    public User(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}