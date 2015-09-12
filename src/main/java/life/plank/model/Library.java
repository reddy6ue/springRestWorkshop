package life.plank.model;


import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by Praneeth on 8/25/2015.
 */
@Entity
public class Library extends AbstractEntity {

    @Transient
    private List<Book> books;

    @Transient
    private List<Student> students;

    @Transient
    public List<Book> getBooks() {
        return books;
    }

    @Transient
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Transient
    public List<Student> getStudents() {
        return students;
    }

    @Transient
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
