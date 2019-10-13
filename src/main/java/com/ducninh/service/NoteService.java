package com.ducninh.service;

import com.ducninh.model.Note;
import com.ducninh.model.TypeNote;

public interface NoteService {

    Iterable<Note> findAll();

    Note findById(int id);

    void save (Note note);

    void remove(int id);

    Iterable<Note> findAllByTypeNote(TypeNote typeNote);










}
