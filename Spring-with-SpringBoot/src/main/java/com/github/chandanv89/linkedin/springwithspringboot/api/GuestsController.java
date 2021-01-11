package com.github.chandanv89.linkedin.springwithspringboot.api;

import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Guest;
import com.github.chandanv89.linkedin.springwithspringboot.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GuestsController
 *
 * @author chandanv89
 **/
@RestController
@RequestMapping("/rest/v1")
public class GuestsController {
    @Autowired
    private GuestRepository repository;

    @GetMapping("/guests")
    public Iterable<Guest> getAllGuests() {
        return repository.findAll();
    }
}
