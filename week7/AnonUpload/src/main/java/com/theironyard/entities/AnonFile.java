package com.theironyard.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by jeff on 7/27/16.
 */
@Entity
@Table(name = "files")
public class AnonFile {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String originalFilename;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean permanent;

    @Column(nullable = false)
    @ColumnDefault("")
    @Size(min = 5, max = 100)
    private String description;

    public AnonFile() {
    }

    public AnonFile(String filename, String originalFilename, String description) {
        this.filename = filename;
        this.originalFilename = originalFilename;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
