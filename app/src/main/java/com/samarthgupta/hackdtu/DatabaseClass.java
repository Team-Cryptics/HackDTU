package com.samarthgupta.hackdtu;

/**
 * Created by samarthgupta on 10/02/17.
 */

public class DatabaseClass {

    private String uid;
    private String hname;
    private String address;
    private int numdoc;
    private int numroom;
    private String phone;
    private String timings;
    private String imageUrl;

    public DatabaseClass() {

    }

    public DatabaseClass(String uid,String imageUrl, String hname, String address, int numdoc, int numroom, String phone, String timings) {

        this.uid= uid;
        this.imageUrl = imageUrl;
        this.hname = hname;
        this.address = address;
        this.numdoc = numdoc;
        this.numroom = numroom;
        this.phone = phone;
        this.timings = timings;

    }
    public String getPhone() {
        return phone;
    }

    public String getUid() {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTimings() {
        return timings;
    }
}
