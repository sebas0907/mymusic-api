package com.projects.music.repositories;

import com.projects.music.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,String> {
    List<Track> findAllByTrackidEquals(Integer id);
    List<Track> findAllByTitleEquals(String title);
    List<Track> findAllByLenEquals(Integer len);
    List<Track> findAllByRatingEquals(Integer rating);
    List<Track> findAllByCountEquals(Integer count);

}
