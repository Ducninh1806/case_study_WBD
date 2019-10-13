package com.ducninh.repository;

import com.ducninh.model.Note;
import com.ducninh.model.TypeNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Integer> {

    Iterable<Note> findAllByTypeNote(TypeNote typeNote);

    Page<Note>findAllByTitleContaining(String title, Pageable pageable);
}
