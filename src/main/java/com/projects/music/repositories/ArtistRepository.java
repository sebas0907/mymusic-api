package com.projects.music.repositories;

import com.projects.music.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, String> {
    List<Artist> findAllByNameEquals(String name);
    List<Artist> findAllByArtistidEquals(Integer id);
}
