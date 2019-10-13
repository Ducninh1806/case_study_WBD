package com.ducninh.controller;

import com.ducninh.model.Note;
import com.ducninh.model.TypeNote;
import com.ducninh.service.NoteService;
import com.ducninh.service.TypeNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private TypeNoteService typeNoteService;

    @ModelAttribute("typeNote")
    public Iterable<TypeNote> typeNotes(){
        return typeNoteService.findAll();
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/note")
    public ModelAndView showListForm(Pageable pageable){
        Page<Note> notes = noteService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @GetMapping("/create-note")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("notes",new Note());
        return modelAndView;
    }

    @PostMapping("/create-note")
    public ModelAndView saveCreate(@ModelAttribute("notes") Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("notes",note);
        return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Note note = noteService.findById(id);
        if (note != null){
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("notes",note);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public String saveEdit(@ModelAttribute("note") Note note){
        noteService.save(note);
        return "redirect:note";
    }

    @GetMapping("/delete-note/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        Note note = noteService.findById(id);
        if (note != null){
            ModelAndView modelAndView = new ModelAndView("/note/delete");
            modelAndView.addObject("notes", note);
            return modelAndView;
        } else {
            ModelAndView modelAndView= new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-note")
    public String saveDelete(int id ){
        noteService.remove(id);
        return "redirect:note";
    }






}
