package com.ccdp.pcmapp4.utils;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Susi on 9/25/2018.
 */
@IgnoreExtraProperties
public class Order {
    public String name;
    public String phonenumber;
    public String ordertype;
    public String orderdetail;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Order() {
    }

    public Order(String name, String phonenumber, String ordertype, String orderdetail) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.ordertype = ordertype;
        this.orderdetail = orderdetail;
    }
}
