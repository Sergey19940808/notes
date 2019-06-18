package web.notes.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import web.notes.dao.NoteDAO;
import web.notes.model.Note;
import web.notes.service.NoteService;

@Component
public class NoteValidator implements Validator {

    @Autowired
    private NoteService noteService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Note.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Note note = (Note) o;
        if (noteService.getOne(note.getTitle()) != null) {
            errors.rejectValue(
                    "title", "","This title is already exists"
            );
        }
    }
}
