package com.hb.noteApp.controllers;

import com.hb.noteApp.dtos.NoteDto;
import com.hb.noteApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/user/{userId}")
    public List<NoteDto> getNotesByUserId(@PathVariable Long userId){
        return noteService.getAllNotesByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public  void addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId){
        noteService.addNote(noteDto, userId);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId){
        noteService.deleteNoteById(noteId);
    }

    @PutMapping
    public void updateNote(@RequestBody NoteDto noteDto){
        noteService.updateNoteById(noteDto);
    }

    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNoteById(@PathVariable Long noteId){
        return noteService.getNoteById(noteId);
    }
}
