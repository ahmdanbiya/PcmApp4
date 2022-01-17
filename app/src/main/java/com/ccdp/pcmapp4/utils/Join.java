package com.ccdp.pcmapp4.utils;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Susi on 10/10/2018.
 */

@IgnoreExtraProperties
public class Join {
    public String name;
    public String idnumber;
    public String email;
    public String phonenumber;
    public String address;
    public String birthdate;

    public Join() {
    }

    public Join(String name, String idnumber, String email, String phonenumber, String address, String birthdate) {
        this.name = name;
        this.idnumber = idnumber;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.birthdate = birthdate;
    }
}