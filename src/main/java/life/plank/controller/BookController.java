package life.plank.controller;

import life.plank.controller.exception.PlankResourceNotFoundException;
import life.plank.model.Book;
import life.plank.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by Praneeth on 9/8/2015.
 */
@RestController // assumes @ResponseBody annotation in methods annotated with  @RequestMapping
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    public static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Book> findBooksByTitle(
            @RequestParam(value = "title") Optional<String> titleParam,
            @RequestParam(value = "yearPublished") Optional<Integer> yearPublishedParam,
            @RequestParam(value = "edition") Optional<Integer> editionParam)
            throws PlankResourceNotFoundException {
        if (    !titleParam.isPresent()
                && !yearPublishedParam.isPresent()
                && !editionParam.isPresent()) {
            logger.debug("Processing request to retrieve all Books");
            return RestPreconditions.checkFound(bookRepository.findAll());
        }

        if (yearPublishedParam.isPresent()) {
            if (editionParam.isPresent()) {
                logger.debug("Processing request to retrieve books with edition %d",
                        editionParam.get());
                return RestPreconditions.checkFound(bookRepository
                        .findByEditionAndYearPublished(editionParam.get(), yearPublishedParam.get()));
            }
            logger.debug("Process request to retrieve books published in year %d",
                    yearPublishedParam.get());
            return RestPreconditions.checkFound(bookRepository
                    .findByYearPublished(yearPublishedParam.get()));
        } else if (titleParam.isPresent()) {
            logger.debug("Processing request to retrieve books by title %s",
                    titleParam.get());
            return RestPreconditions.checkFound(bookRepository.findByTitle(titleParam.get()));
        }
        throw new IllegalArgumentException("Cannot recognize attribute");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void deleteBook(@PathVariable("id") Long id) {
        bookRepository.delete(id);
    }
}