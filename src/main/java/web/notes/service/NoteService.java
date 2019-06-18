package web.notes.service;

import org.springframework.stereotype.Service;
import web.notes.model.Note;

import java.util.List;

@Service
public interface NoteService {
    List<Note> getAll();

    List<Note> filterTitle(String title);

    List<Note> filterName(String name);

    Note getOne(String email);

    void add(Note note);

    void delete(String title);
}
