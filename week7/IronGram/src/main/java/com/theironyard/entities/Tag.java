package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by jeff on 8/1/16.
 */
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String value;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Collection<Photo> photos;

    public Tag(String value) {
        this.value = value;
    }

    public Tag() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Collection<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<Photo> photos) {
        this.photos = photos;
    }
}
