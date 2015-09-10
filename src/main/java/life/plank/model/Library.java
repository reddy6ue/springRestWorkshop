package life.plank.model;


/**
 * Created by Praneeth on 8/25/2015.
 */
public class Library extends AbstractEntity {

    private Book[] books;

    private Student[] students;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
