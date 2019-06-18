package web.notes.dao;

import org.springframework.stereotype.Component;
import web.notes.model.Note;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class JpaNoteDAO implements NoteDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<Note> getAll() {
        return entityManager.createQuery(
                "select n from Note n",
                Note.class
        ).getResultList();
    }

    @Override
    public Note getOne(String title) {
        TypedQuery<Note> q = entityManager.createQuery(
                "select n from Note n where n.title = :title",
                Note.class
        );
        q.setParameter("title", title);
        return q.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void add(Note note) {
        entityManager.persist(note);
    }

    @Override
    public void delete(String title) {
        TypedQuery<Note> q = entityManager.createQuery(
                "delete from Note n where n.title = :title",
                Note.class
        );
        q.setParameter("title", title);
    }
}
