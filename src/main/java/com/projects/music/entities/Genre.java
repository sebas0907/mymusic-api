package com.projects.music.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Genre")
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id",insertable = false,updatable = false)
    private Integer genreid;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "genre")
    private List<Track> tracks;

    public Genre(Integer genreid, String name, List<Track> tracks) {
        this.genreid = genreid;
        this.name = name;
        this.tracks = tracks;
    }

    public Integer getGenreid() {
        return genreid;
    }

    public void setGenreid(Integer genreid) {
        this.genreid = genreid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
