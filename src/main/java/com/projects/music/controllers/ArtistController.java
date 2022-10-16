package com.projects.music.controllers;

import com.projects.music.entities.Artist;
import com.projects.music.repositories.ArtistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistRepository artists;
    public ArtistController(ArtistRepository artists) {
        this.artists = artists;
    }

    public ArtistRepository getArtists() {
        return artists;
    }

    @GetMapping("/")
    ResponseEntity<List<Artist>> allArtists() {
        List<Artist> artists = getArtists().findAll();
        if(!artists.isEmpty()) {
            return new ResponseEntity<>(artists, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/artist")
    ResponseEntity<List<Artist>> artistsByName(@RequestParam(value = "name") String name) {
        List<Artist> artists = getArtists().findAllByNameEquals(name);
        if(!artists.isEmpty()) {
            return new ResponseEntity<>(artists, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Artist>> artistsById(@PathVariable Integer id) {
        List<Artist> artists = getArtists().findAllByArtistidEquals(id);
        if(!artists.isEmpty()) {
            return new ResponseEntity<>(artists, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
