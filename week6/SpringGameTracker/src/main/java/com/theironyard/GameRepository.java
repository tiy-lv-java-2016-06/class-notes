package com.theironyard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by jeff on 7/19/16.
 */
public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByGenre(String genre);

    List<Game> findByReleaseYear(int year);
    List<Game> findByGenreAndReleaseYear(String genre, int year);
    List<Game> findByReleaseYearIsGreaterThanEqual(int year);

    Game findFirstByGenre(String genre);
    int countByGenre(String genre);
    List<Game> findByGenreOrderByNameAsc(String genre);

    List<Game> findByNameStartingWithIgnoreCase(String name);
}
