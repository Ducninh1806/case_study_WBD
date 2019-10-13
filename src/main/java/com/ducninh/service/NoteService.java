package com.ducninh.service;

import com.ducninh.model.Note;
import com.ducninh.model.TypeNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {

    Page<Note> findAll(Pageable pageable);

    Note findById(int id);

    void save (Note note);

    void remove(int id);

    Iterable<Note> findAllByTypeNote(TypeNote typeNote);










}
