package com.rmit.sept.bk_bookservices.bookmicroservices.repository;

import com.rmit.sept.bk_bookservices.bookmicroservices.model.Book;
import com.rmit.sept.bk_bookservices.bookmicroservices.service.BookServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class BookRepositoryTest {


    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private BookRepository bookRepository;

    private Book bookT1;
    private Book bookT2;
    private Book bookT3;
    private Book bookT4;

    @BeforeAll
    void beforeAll() {

        bookT2 = new Book();
        bookT2.setTitle("title");
        bookT2.setAuthor("author");
        bookT2.setCoverPhotoURL("coverURL");
        bookT2.setIsbnNumber(651615L);
        bookT2.setPrice(25.0);
        bookT2.setLanguage("French");
        bookT2.setGenre("Technology");
        bookT2.setBlurb("blurb");
        bookT2.setAuthorDescription("author description");
        bookT2.setRating(3.1);
        bookT2.setTableOfContents("contents");

        bookT3 = new Book();
        bookT3.setTitle("title");
        bookT3.setAuthor("author");
        bookT3.setCoverPhotoURL("coverURL");
        bookT3.setIsbnNumber(651615L);
        bookT3.setPrice(25.0);
        bookT3.setLanguage("French");
        bookT3.setGenre("Technology");
        bookT3.setBlurb("blurb");
        bookT3.setAuthorDescription("author description");
        bookT3.setRating(3.1);
        bookT3.setTableOfContents("contents");

        bookT4 = new Book();
        bookT4.setTitle("title");
        bookT4.setAuthor("author");
        bookT4.setCoverPhotoURL("coverURL");
        bookT4.setIsbnNumber(651615L);
        bookT4.setPrice(25.0);
        bookT4.setLanguage("French");
        bookT4.setGenre("Technology");
        bookT4.setBlurb("blurb");
        bookT4.setAuthorDescription("author description");
        bookT4.setRating(3.1);
        bookT4.setTableOfContents("contents");
    }

    @BeforeEach
    void setEach() {

        bookT1 = new Book();
        bookT1.setTitle("title");
        bookT1.setAuthor("author");
        bookT1.setCoverPhotoURL("coverURL");
        bookT1.setIsbnNumber(651615L);
        bookT1.setPrice(25.0);
        bookT1.setLanguage("French");
        bookT1.setGenre("Technology");
        bookT1.setBlurb("blurb");
        bookT1.setAuthorDescription("author description");
        bookT1.setRating(3.1);
        bookT1.setTableOfContents("contents");
    }


    @AfterEach
    void afterEach() {
        bookService.deleteAllBooks();
    }

    @AfterAll
    void afterAll() { bookService.deleteAllBooks();}


    @Test
    @DisplayName("findAllRequests: If db is empty, returns empty collection")
    void _1_findAllRequests_collectionEmpty_emptyDB() {


        Iterable<Book> allBooks = bookRepository.findAll();
        assertFalse(allBooks.iterator().hasNext());

    }

    @Test
    @DisplayName("findAllRequests: If db has one book, returns non-empty collection")
    void _2_findAllRequests_collectionEmpty_oneRequestInDB() {

        bookService.saveOrUpdate(this.bookT1);
        Iterable<Book> allUsers = bookRepository.findAll();
        assertTrue(allUsers.iterator().hasNext());

    }

    @Test
    @DisplayName("findAllRequests: If db has many books, returns collection of size = db.count()")
    void _3_findAllRequests_collectionSizeOfDB_manyRequestsInDB() {

        bookService.saveOrUpdate(this.bookT2);
        bookService.saveOrUpdate(this.bookT3);
        bookService.saveOrUpdate(this.bookT4);

        Iterable<Book> allBooks = bookRepository.findAll();
        Iterator<Book> it = allBooks.iterator();

        int size;

        if (allBooks instanceof Collection) {
            size =  ((Collection<?>) allBooks).size();
        } else {
            size = 0;
            while(it.hasNext()) {
                it.next();
                size++;
            }
        }
        assertEquals(bookRepository.count(), size);

    }
}
