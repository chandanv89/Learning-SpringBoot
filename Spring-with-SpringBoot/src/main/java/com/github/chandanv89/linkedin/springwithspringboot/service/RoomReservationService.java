package com.github.chandanv89.linkedin.springwithspringboot.service;

import com.github.chandanv89.linkedin.springwithspringboot.model.domain.RoomReservation;
import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Guest;
import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Reservation;
import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Room;
import com.github.chandanv89.linkedin.springwithspringboot.repository.GuestRepository;
import com.github.chandanv89.linkedin.springwithspringboot.repository.ReservationRepository;
import com.github.chandanv89.linkedin.springwithspringboot.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * RoomReservationService
 *
 * @author chandanv89
 **/
@Service
public class RoomReservationService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<RoomReservation> getRoomReservationsFor(Date date) {
        Iterable<Reservation> reservations = reservationRepository.findReservationByDate(new java.sql.Date(date.getTime()));
        List<RoomReservation> roomReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setDate(reservation.getDate());
            roomReservation.setRoomId(reservation.getRoomId());
            roomReservation.setGuestId(reservation.getGuestId());
            roomReservation.setReservationId(reservation.getReservationId());

            Optional<Room> room = roomRepository.findById(reservation.getRoomId());
            Optional<Guest> guest = guestRepository.findById(reservation.getGuestId());

            if (room.isPresent()) {
                Room r = room.get();
                roomReservation.setRoomName(r.getName());
                roomReservation.setRoomNumber(r.getRoomNumber());
            }

            if (guest.isPresent()) {
                Guest g = guest.get();
                roomReservation.setFirstName(g.getFirstName());
                roomReservation.setLastName(g.getLastName());
                roomReservation.setEmailAddress(g.getEmailAddress());
                roomReservation.setPhoneNumber(g.getPhoneNumber());
            }

            roomReservations.add(roomReservation);
        }
        return roomReservations;
    }
}
