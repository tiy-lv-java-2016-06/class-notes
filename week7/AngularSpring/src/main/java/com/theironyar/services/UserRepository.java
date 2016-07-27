package com.theironyar.services;

import com.theironyar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeff on 7/27/16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
