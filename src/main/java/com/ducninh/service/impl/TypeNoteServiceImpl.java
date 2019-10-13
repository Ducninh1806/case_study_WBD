package com.ducninh.service.impl;

import com.ducninh.model.TypeNote;
import com.ducninh.repository.TypeNoteRepository;
import com.ducninh.service.TypeNoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeNoteServiceImpl implements TypeNoteService {

    @Autowired
    private TypeNoteRepository typeNoteRepository;


    @Override
    public Iterable<TypeNote> findAll() {
        return typeNoteRepository.findAll();
    }

    @Override
    public TypeNote findById(int id) {
        return typeNoteRepository.findOne(id);
    }

    @Override
    public void save(TypeNote typeNote) {
        typeNoteRepository.save(typeNote);
    }

    @Override
    public void remove(int id) {
        typeNoteRepository.delete(id);
    }
}
