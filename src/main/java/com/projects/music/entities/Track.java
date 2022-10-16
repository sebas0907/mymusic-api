package com.projects.music.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Track")
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Integer trackid;
    private String title;
    private Integer len;
    private Integer rating;
    private Integer count;
    //@ManyToOne(targetEntity = Album.class, cascade = CascadeType.ALL)
    @Column(name = "album_id",insertable = false,updatable = false)
    private Integer albumid;
    @Column(name = "genre_id",insertable = false,updatable = false)
    private Integer genreid;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "album_id")
    private Album album;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre genre;

    public Track(Integer trackid, String title, Integer len, Integer rating, Integer count, Integer albumid, Integer genreid, Album album, Genre genre) {
        this.trackid = trackid;
        this.title = title;
        this.len = len;
        this.rating = rating;
        this.count = count;
        this.albumid = albumid;
        this.genreid = genreid;
        this.album = album;
        this.genre = genre;
    }

    public Integer getTrackid() {
        return trackid;
    }

    public void setTrackid(Integer trackid) {
        this.trackid = trackid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public Integer getGenreid() {
        return genreid;
    }

    public void setGenreid(Integer genreid) {
        this.genreid = genreid;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
