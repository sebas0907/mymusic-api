package com.projects.music.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Artist")
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id",insertable = false,updatable = false)
    private Integer artistid;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    public Artist(Integer artistid, String name, List<Album> albums) {
        this.artistid = artistid;
        this.name = name;
        this.albums = albums;
    }

    public Integer getArtistid() {
        return artistid;
    }

    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
