package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeff on 7/20/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    User findFirstByName(String name);

}
