package com.example.a09cinema_backenddevelop.model;

import java.time.LocalDateTime;
public class BookedTicket {
    private String name;
    private LocalDateTime dayTimeBooking;
    private double totalPrice;
    private boolean received;

    public BookedTicket( String name, LocalDateTime dayTimeBooking, double totalPrice, boolean received) {
        this.name = name;
        this.dayTimeBooking = dayTimeBooking;
        this.totalPrice = totalPrice;
        this.received = received;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDayTimeBooking() {
        return dayTimeBooking;
    }

    public void setDayTimeBooking(LocalDateTime dayTimeBooking) {
        this.dayTimeBooking = dayTimeBooking;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }
}
