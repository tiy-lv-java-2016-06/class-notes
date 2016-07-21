package com.theironyard.services;

import com.theironyard.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jeff on 7/21/16.
 */
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByOrderByDateTimeDesc();
}
