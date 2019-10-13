package com.ducninh.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TypeNote")
public class TypeNote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;



    @OneToMany(targetEntity = Note.class)
    private List<Note> note;



    public TypeNote() {
    }

    public TypeNote(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }
}
