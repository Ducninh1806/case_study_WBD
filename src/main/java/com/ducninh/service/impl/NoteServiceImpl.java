package com.ducninh.service.impl;

import com.ducninh.model.Note;
import com.ducninh.model.TypeNote;
import com.ducninh.repository.NoteRepository;
import com.ducninh.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;


    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(int id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(int id) {
        noteRepository.delete(id);
    }

    @Override
    public Iterable<Note> findAllByTypeNote(TypeNote typeNote) {
        return noteRepository.findAllByTypeNote(typeNote);
    }
}
