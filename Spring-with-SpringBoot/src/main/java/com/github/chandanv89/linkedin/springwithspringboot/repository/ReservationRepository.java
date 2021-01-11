package com.github.chandanv89.linkedin.springwithspringboot.repository;

import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * ReservationRepository
 *
 * @author chandanv89
 **/
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByDate(Date date);
}
