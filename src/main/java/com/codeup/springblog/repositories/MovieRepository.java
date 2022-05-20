package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleIsLikeIgnoreCase(String title);
    List<Movie> findByTitleContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description);

    List<Movie> findByIdEquals(Long id);



}