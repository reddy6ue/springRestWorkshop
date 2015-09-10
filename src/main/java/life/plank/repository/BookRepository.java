package life.plank.repository;

import life.plank.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

/**
 * Created by Praneeth on 9/8/2015.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    public Iterable<Book> findByTitle(@Param("title") String title);
    public Iterable<Book> findByYearPublished(@Param("yearPublished") Integer yearPublished);
    public Iterable<Book> findByEditionAndYearPublished(@Param("edition") Integer edition, @Param("yearPublished") Integer yearPublished);
}
