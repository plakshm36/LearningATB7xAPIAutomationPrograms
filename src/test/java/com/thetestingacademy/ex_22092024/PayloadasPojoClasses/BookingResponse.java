package com.thetestingacademy.ex_22092024.PayloadasPojoClasses;

public class BookingResponse {
/*    {
        "bookingid": 9992,
            "booking": {
        "firstname": "Papri",
                "lastname": "Lak",
                "totalprice": 10000,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2024-09-05",
                    "checkout": "2024-09-05"
        },
        "additionalneeds": "Breakfast"
    }
    }*/
//This getter setter encapsulation method can be written manually or u can use the online www.jsonschema2pojo.org/
//to convert the json responsestrings to getter setter methods.We are basically converting all output response to classes
    private Integer bookingid;
    private Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}