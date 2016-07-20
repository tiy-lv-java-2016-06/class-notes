package com.theironyard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by jeff on 7/19/16.
 */
public interface GameRepository extends JpaRepository<Game, Integer> {
    Page<Game> findByGenre(Pageable pr, String genre);
    List<Game> findByReleaseYearOrderByNameDesc(int year);

//    @Query("SELECT g FROM Game g WHERE g.name LIKE ?1%")
//    List<Game> findByNameStartsWith(String name);
    List<Game> findByNameStartingWithIgnoreCase(String name);
}
