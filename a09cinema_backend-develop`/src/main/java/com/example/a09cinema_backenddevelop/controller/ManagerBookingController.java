package com.example.a09cinema_backenddevelop.controller;
import com.example.a09cinema_backenddevelop.model.entity.Booking;
import com.example.a09cinema_backenddevelop.service.ManagerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/managerBooking")
public class ManagerBookingController {
    @Autowired
    private ManagerBookingService service;
    @GetMapping("/list")
    public ResponseEntity<Page<Booking>> getAllBooking(@RequestParam(defaultValue = "") String key,@PageableDefault(size =10) Pageable pageable){
        Page<Booking>bookings=service.findAll(key, pageable);
        if (bookings.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    @GetMapping("/{id}/detail")
    public ResponseEntity<Booking> findBookingById(@PathVariable Long id) {
        Optional<Booking> bookingOptional = service.getById(id);
        if (!bookingOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookingOptional.get(), HttpStatus.OK);

    }
    @GetMapping("/{id}/takeTicket")
    public ResponseEntity<Booking> takeTicket(@PathVariable Long id) {
        Optional<Booking> booking = service.getById(id);
        if (booking.isPresent()){
            if (booking.get().getTotalPrice()<booking.get().getAccount().getTotalPoint()){
                booking.get().setReceived(true);
                service.save(booking.get());
                return new ResponseEntity<>(booking.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
