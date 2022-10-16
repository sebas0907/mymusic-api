package com.projects.music.repositories;

import com.projects.music.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,String> {
    List<Genre> findAllByGenreidEquals(Integer id);
    List<Genre> findAllByNameEquals(String name);
}
