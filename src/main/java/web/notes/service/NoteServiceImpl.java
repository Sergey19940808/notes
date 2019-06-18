package web.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.notes.model.Note;
import web.notes.repository.NoteRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public List<Note> filterTitle(String title) {
        return noteRepository.findAllByTitle(title);
    }

    @Override
    public List<Note> filterName(String name) {
        return noteRepository.findAllByName(name);
    }

    @Override
    public Note getOne(String title) {
        return noteRepository.findByTitle(title);
    }

    @Override
    @Transactional
    public void add(Note note) {
        noteRepository.save(note);
    }

    @Override
    @Transactional
    public void delete(String title) {
        noteRepository.deleteNoteByTitle(title);
    }
}
