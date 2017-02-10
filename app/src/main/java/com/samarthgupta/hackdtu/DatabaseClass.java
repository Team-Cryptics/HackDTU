package com.samarthgupta.hackdtu;

import android.provider.ContactsContract;

/**
 * Created by samarthgupta on 10/02/17.
 */

public class DatabaseClass {

    private int uid;
    private String hname;
    private String address;
    private int numdoc;
    private int numroom;
    private String phone;

    public DatabaseClass() {

    }

    public DatabaseClass(int uid, String hname, String address, int numdoc, int numroom, String phone) {

        this.uid= uid;
        this.hname = hname;
        this.address = address;
        this.numdoc = numdoc;
        this.numroom = numroom;
        this.phone = phone;

    }
    public String getPhone() {
        return phone;
    }

    public int getUid() {
        return uid;
    }

    public String getHname() {
        return hname;
    }

    public String getAddress() {
        return address;
    }

    public int getNumdoc() {
        return numdoc;
    }

    public int getNumroom() {
        return numroom;
    }
}
