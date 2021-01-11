package com.github.chandanv89.linkedin.springwithspringboot.api;

import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Room;
import com.github.chandanv89.linkedin.springwithspringboot.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoomsController
 *
 * @author chandanv89
 */
@RestController
@RequestMapping("/rest/v1")
public class RoomsController {
    @Autowired
    private RoomRepository repository;

    @GetMapping("/rooms")
    public Iterable<Room> getAllRooms() {
        return repository.findAll();
    }
}
