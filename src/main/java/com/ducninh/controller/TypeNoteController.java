package com.ducninh.controller;

import com.ducninh.model.Note;
import com.ducninh.model.TypeNote;
import com.ducninh.service.NoteService;
import com.ducninh.service.TypeNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeNoteController {

    @Autowired
    private TypeNoteService typeNoteService;

    @Autowired
    private NoteService noteService;

    @GetMapping("/view-typeNote/{id}")
    public ModelAndView viewTypeNote(@PathVariable("id") int id){
        TypeNote typeNote = typeNoteService.findById(id);
        if (typeNote ==null){
            return new ModelAndView("/error.404");
        }

        Iterable<Note> notes = noteService.findAllByTypeNote(typeNote);
        ModelAndView modelAndView = new ModelAndView("/typeNote/view");
        modelAndView.addObject("typeNote",typeNote);
        modelAndView.addObject("note",notes);
        return modelAndView;

    }

    @GetMapping("/typeNote")
    public ModelAndView showListForm(){
        Iterable<TypeNote> typeNotes = typeNoteService.findAll();
        ModelAndView modelAndView = new ModelAndView("/typeNote/list");
        modelAndView.addObject("typeNotes",typeNotes);
        return modelAndView;
    }

    @GetMapping("/create-typeNote")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/typeNote/create");
        modelAndView.addObject("typeNote",new TypeNote());
        return modelAndView;
    }

    @PostMapping("/create-type")
    public ModelAndView saveCreate(@ModelAttribute("typeNote") TypeNote typeNote){
        typeNoteService.save(typeNote);
        ModelAndView modelAndView = new ModelAndView("/typeNote/create");
        modelAndView.addObject("typeNote",typeNote);
        return modelAndView;
    }


    @GetMapping("edit-typeNote/{id}")
    public ModelAndView showEditForm(@PathVariable("id")int id){
        TypeNote typeNote= typeNoteService.findById(id);
        if (typeNote != null){
            ModelAndView modelAndView = new ModelAndView("/typeNote/edit");
            modelAndView.addObject("typeNote",typeNote);
            return modelAndView;
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-typeNote")
    public String saveEdit(TypeNote typeNote){
        typeNoteService.save(typeNote);
        return "redirect:typeNote";
    }

    @GetMapping("delete-typeNote/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id")int id){
        TypeNote typeNote= typeNoteService.findById(id);
        if (typeNote != null){
            ModelAndView modelAndView = new ModelAndView("/typeNote/delete");
            modelAndView.addObject("typeNote",typeNote);
            return modelAndView;
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-typeNote")
    public String saveDelete(int id){
        typeNoteService.remove(id);
        return "redirect:typeNote";
    }


}
