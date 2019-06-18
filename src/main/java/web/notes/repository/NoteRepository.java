package web.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.notes.model.Note;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findByTitle(String title);

    void deleteNoteByTitle(String title);

    List<Note> findAllByTitle(String title);
    List<Note> findAllByName(String name);
}
