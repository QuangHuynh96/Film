package com.example.a09cinema_backenddevelop.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
//@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dayTimeBooking;
//- Hiện tại em muốn chuyển ngày booking sang String
//-> khi tạo booking thì mình parse nó sang kiểu LocalDate để lấy ngày hiện tại
//, nếu muốn lấy cả time thì parse sang LocalDateTime
//

    private double totalPrice;
    private int pointExchange;
    private int pointReward;
    private String bookingCode;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean received;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

//    @OneToOne(mappedBy = "booking")
//    private History history;

    public Booking() {}

    public Booking(long id, LocalDateTime dayTimeBooking, double totalPrice, int pointExchange, int pointReward, String bookingCode, boolean received, Account account, List<Ticket> tickets) {
        this.id = id;
        this.dayTimeBooking = dayTimeBooking;
        this.totalPrice = totalPrice;
        this.pointExchange = pointExchange;
        this.pointReward = pointReward;
        this.bookingCode = bookingCode;
        this.received = received;
        this.account = account;
        this.tickets = tickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getPointExchange() {
        return pointExchange;
    }

    public void setPointExchange(int pointExchange) {
        this.pointExchange = pointExchange;
    }

    public int getPointReward() {
        return pointReward;
    }

    public void setPointReward(int pointReward) {
        this.pointReward = pointReward;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
