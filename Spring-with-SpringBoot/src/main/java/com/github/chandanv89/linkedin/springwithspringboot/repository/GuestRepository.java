package com.github.chandanv89.linkedin.springwithspringboot.repository;

import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * GuestRepository
 *
 * @author chandanv89
 **/
@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
