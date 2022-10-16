package com.projects.music.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Album")
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id",insertable = false,updatable = false)
    private Integer albumid;
    private String title;
    @Column(name = "artist_id",insertable = false,updatable = false)
    private Integer artistid;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
    private Artist artist;
    @JsonBackReference
    @OneToMany(mappedBy = "album")
    private List<Track> tracks;

    public Album(Integer albumid, String title, Integer artistid, Artist artist, List<Track> tracks) {
        this.albumid = albumid;
        this.title = title;
        this.artistid = artistid;
        this.artist = artist;
        this.tracks = tracks;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getArtistid() {
        return artistid;
    }

    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
