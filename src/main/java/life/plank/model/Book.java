package life.plank.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Praneeth on 8/25/2015.
 */
@Entity
public class Book extends AbstractEntity {
    public static int instanceCount = 0;

    @NotNull
    @Size(max = 255)
    private String title;

    @ManyToMany
    private List<Author> authors;

//    @ManyToMany(mappedBy = "books")
//    private List<Student> students;

    @NotNull
    private int yearPublished;

    @NotNull
    private int edition;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

//    public List<Student> getStudents() { return students; }
//
//    public void setStudents(List<Student> students) {students = students; }
}
