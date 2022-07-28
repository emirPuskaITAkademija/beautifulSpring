package com.akademija.beautiful.service.note;

import com.akademija.beautiful.entity.note.Note;
import com.akademija.beautiful.entity.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public int saveNote(Note note){
        noteRepository.save(note);
        return 1;
    }

    public int updateNote(Note note){
        noteRepository.save(note);
        return 2;
    }

    public String deleteRow(long id) {
        noteRepository.deleteById(id);
        return "Success";
    }

    public Note getNoteById(long id) {
        Optional<Note> optional = noteRepository.findById(id);
        Note note = optional.get();
        return note;
    }
}
