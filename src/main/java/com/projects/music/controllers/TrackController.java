package com.projects.music.controllers;

import com.projects.music.entities.Track;
import com.projects.music.repositories.TrackRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    private final TrackRepository tracks;

    public TrackController(TrackRepository tracks) {
        this.tracks = tracks;
    }

    public TrackRepository getTracks() {
        return tracks;
    }

    @GetMapping("/")
    ResponseEntity<List<Track>> allTracks() {
        List<Track> tracks = getTracks().findAll();
        if(!tracks.isEmpty()) {
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/track")
    ResponseEntity<List<Track>> tracksByName(@RequestParam(value = "title") String title) {
        List<Track> tracks = getTracks().findAllByTitleEquals(title);
        if(!tracks.isEmpty()) {
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Track>> tracksById(@PathVariable Integer id) {
        List<Track> tracks = getTracks().findAllByTrackidEquals(id);
        if(!tracks.isEmpty()) {
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
