package com.example.a09cinema_backenddevelop.model;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/*
    Nguyen Phuoc Dai Toan
    Get a few field in table booking to display history point of user
*/
public interface History {
    Long getId();
    @Value("#{target.name}")
    String getFilmName();
    @Value("#{target.day_time_booking}")
    LocalDateTime getDate();
    @Value("#{target.point_reward}")
    int getPointReward();
    @Value("#{target.point_exchange}")
    int getPointExchange();
}
