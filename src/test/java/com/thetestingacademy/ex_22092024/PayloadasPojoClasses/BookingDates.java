package com.thetestingacademy.ex_22092024.PayloadasPojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingDates {
    //This getter setter encapsulation method can be written manually or u can use the online www.jsonschema2pojo.org/
    //to convert the json requeststrings to getter setter methods.We are basically converting all input request to
    //classes
/*    {
        "firstname" : "Papri",
            "lastname" : "Lak",
            "totalprice" :10000,
            "depositpaid" : true,
            "bookingdates" : {
        "checkin" : "2024-09-05",
                "checkout" : "2024-09-05"
    },
        "additionalneeds" : "Breakfast"
    }*/
    @SerializedName("checkin")
    @Expose
    private String checkin;
    @SerializedName("checkout")
    @Expose
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}

