package com.projects.music.controllers;

import com.projects.music.entities.Genre;
import com.projects.music.repositories.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreRepository genres;

    public GenreController(GenreRepository genres) {
        this.genres = genres;
    }

    public GenreRepository getGenres() {
        return genres;
    }

    @GetMapping("/")
    ResponseEntity<List<Genre>> allGenres() {
        List<Genre> genres = getGenres().findAll();
        if(!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/genre")
    ResponseEntity<List<Genre>> artistsByName(@RequestParam(value = "name") String name) {
        List<Genre> genres = getGenres().findAllByNameEquals(name);
        if(!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Genre>> genresById(@PathVariable Integer id) {
        List<Genre> genres = getGenres().findAllByGenreidEquals(id);
        if(!genres.isEmpty()) {
            return new ResponseEntity<>(genres, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
