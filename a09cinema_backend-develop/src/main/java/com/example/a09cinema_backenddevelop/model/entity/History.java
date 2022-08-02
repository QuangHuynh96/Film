//package com.example.a09cinema_backenddevelop.model.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Data
//@Entity
//
//public class History {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private Date dateChange;
//    private int pointChange;
//    private int pointPlus;
//
//    @OneToOne(mappedBy = "history")
//    private Booking booking;
//
//}
