package com.samarthgupta.hackdtu;

import android.provider.ContactsContract;

/**
 * Created by samarthgupta on 10/02/17.
 */

public class DatabaseClass {

    int uid;
    String hname;
    String address;
    int numdoc;
    int numroom;
    String phone;

    public DatabaseClass() {

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
