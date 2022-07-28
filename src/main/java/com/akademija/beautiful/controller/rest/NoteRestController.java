package com.akademija.beautiful.controller.rest;

import com.akademija.beautiful.entity.note.Note;
import com.akademija.beautiful.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteRestController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public void addNote(@RequestBody Note note){
        noteService.saveNote(note);
    }

    @GetMapping(value = "/show", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Note> showNotes(){
        return noteService.getAllNotes();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteData(@PathVariable("id") long id) {
        String row = noteService.deleteRow(id);
        System.out.println(row);
    }

    @GetMapping("/notes/{id}")
    public Note getSingleNote(@PathVariable("id") long id) {
        Note note = noteService.getNoteById(id);
        System.out.println(note);
        return note;
    }
    @PutMapping("/update")
    public void updateUser(@RequestBody Note note) {
        System.out.println("Updating" + note.getId());
        Note newNote = new Note(note.getId(), note.getTopicName(), note.getNote());
        noteService.updateNote(newNote);
    }
}
