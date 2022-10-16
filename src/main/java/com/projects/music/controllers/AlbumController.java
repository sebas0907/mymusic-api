package com.projects.music.controllers;

import com.projects.music.entities.Album;
import com.projects.music.repositories.AlbumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albums;

    public AlbumController(AlbumRepository albums) {
        this.albums = albums;
    }

    public AlbumRepository getAlbums() {
        return albums;
    }

    @GetMapping("/")
    ResponseEntity<List<Album>> allAlbums() {
        List<Album> albums = getAlbums().findAll();
        if(!albums.isEmpty()) {
            return new ResponseEntity<>(albums, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/album")
    ResponseEntity<List<Album>> albumsByTitle(@RequestParam(value = "title") String title) {
        List<Album> albums = getAlbums().findAllByTitleEquals(title);
        if(!albums.isEmpty()) {
            return new ResponseEntity<>(albums, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<List<Album>> albumsById(@PathVariable Integer id) {
        List<Album> albums = getAlbums().findAllByAlbumidEquals(id);
        if(!albums.isEmpty()) {
            return new ResponseEntity<>(albums, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
