package com.example.a09cinema_backenddevelop.model.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.voodoodyne.jackson.jsog.JSOGGenerator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dayTimeBooking;

    private double totalPrice;
    private int pointExchange;
    private int pointReward;
    private String bookingCode;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean received;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
//    @JsonBackReference("account-booking")
    private Account account;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<SeatDetail> seatDetails;

}
