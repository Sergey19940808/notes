package web.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.notes.lib.NoteValidator;
import web.notes.model.Note;
import web.notes.service.NoteService;

import javax.validation.Valid;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteValidator noteValidator;

    @GetMapping("/*")
    public String notFound(Model model) {
        model.addAttribute("title", "Страница не найдена");
        model.addAttribute("msg", "Страница по заданному урлу не найдена");
        return "404";
    }

    @GetMapping("/")
    public String entrypoint() {
        return "redirect:/notes";
    }

    @GetMapping("/notes")
    public String index(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "name", required = false) String name,
            Model model
    ) {
        model.addAttribute("title", "Главная");
        model.addAttribute("msg", "Все заметки");

        if (title != "" && title != null) {
            model.addAttribute("notes", noteService.filterTitle(title));
        } else if (name != "" && title != null) {
            model.addAttribute("notes", noteService.filterName(name));
        } else {
            model.addAttribute("notes", noteService.getAll());
        }
        return "notes";
    }

    @GetMapping("/create")
    public String getCreateForm(Note note, Model model) {
        model.addAttribute("title", "Создание");
        model.addAttribute("msg", "Создание заметки");
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Valid Note note, BindingResult result, Model model) {
        noteValidator.validate(note, result);
        if (result.hasErrors()) {
            model.addAttribute("title", "Создание");
            model.addAttribute("msg", "Создание заметки");
            return "/create";
        }
        noteService.add(note);
        return "redirect:/notes";
    }

    @GetMapping("/delete/{title}")
    String delete(@PathVariable("title") String title) {
        noteService.delete(title);
        return "redirect:/notes";
    }
}
