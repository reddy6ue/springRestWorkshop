package life.plank.service;

import life.plank.model.Author;
import life.plank.model.Book;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * Created by Praneeth on 9/10/2015.
 */
@Service
public interface BookService {
    void addAuthorToBook(Book book, Author author);
}
