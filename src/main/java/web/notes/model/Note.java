package web.notes.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 30, message = "Title should be from 1 to 30 symbols")
    private String title;

    @NotBlank(message = "Name is required")
    private String name;

    public Note() {

    }

    public Note(String title, String name) {
        this.title = title;
        this.name = name;
    }

    public Long getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getName() { return name; }

    public void setTitle(String title) { this.title = title; }

    public void setName(String name) { this.name = name; }

    public void setId(Long id) { this.id = id; }
}
