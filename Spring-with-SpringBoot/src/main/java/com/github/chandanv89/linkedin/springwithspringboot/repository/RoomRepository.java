package com.github.chandanv89.linkedin.springwithspringboot.repository;

import com.github.chandanv89.linkedin.springwithspringboot.model.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RoomRepository
 *
 * @author chandanv89
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
