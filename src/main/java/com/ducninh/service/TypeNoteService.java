package com.ducninh.service;

import com.ducninh.model.TypeNote;

public interface TypeNoteService {

    Iterable<TypeNote> findAll();

    TypeNote findById(int id);

    void save(TypeNote typeNote);

    void remove(int id);




}
