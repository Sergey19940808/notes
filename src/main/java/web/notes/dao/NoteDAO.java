package web.notes.dao;

import web.notes.model.Note;

import java.util.List;

public interface NoteDAO {
    List<Note> getAll();

    Note getOne(String email);

    void add(Note note);

    void delete(String title);
}