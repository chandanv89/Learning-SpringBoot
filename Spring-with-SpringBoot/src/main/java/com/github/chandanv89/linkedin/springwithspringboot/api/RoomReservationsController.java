package com.github.chandanv89.linkedin.springwithspringboot.api;

import com.github.chandanv89.linkedin.springwithspringboot.model.domain.RoomReservation;
import com.github.chandanv89.linkedin.springwithspringboot.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * RoomReservationsController
 *
 * @author chandanv89
 **/
@RestController
@RequestMapping("/rest/v1")
public class RoomReservationsController {
    @Autowired
    private RoomReservationService service;

    @GetMapping("/room-reservations/{date}")
    public List<RoomReservation> getRoomReservationsFor(@PathVariable(name = "date") String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);
        System.out.println(date);
        List<RoomReservation> reservations = service.getRoomReservationsFor(date);
        System.out.println(reservations);
        return reservations;
    }
}
