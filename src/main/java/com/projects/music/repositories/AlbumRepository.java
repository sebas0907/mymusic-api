package com.projects.music.repositories;

import com.projects.music.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,String> {
    List<Album> findAllByAlbumidEquals(Integer id);
    List<Album> findAllByTitleEquals(String title);
}
