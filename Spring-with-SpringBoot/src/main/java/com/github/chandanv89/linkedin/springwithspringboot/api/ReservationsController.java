package com.github.chandanv89.linkedin.springwithspringboot.api;

import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Reservation;
import com.github.chandanv89.linkedin.springwithspringboot.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReservationsController
 *
 * @author chandanv89
 **/
@RestController
@RequestMapping("/rest/v1")
public class ReservationsController {
    @Autowired
    private ReservationRepository repository;

    @GetMapping("/reservations")
    public Iterable<Reservation> getAllReservations() {
        return repository.findAll();
    }
}
