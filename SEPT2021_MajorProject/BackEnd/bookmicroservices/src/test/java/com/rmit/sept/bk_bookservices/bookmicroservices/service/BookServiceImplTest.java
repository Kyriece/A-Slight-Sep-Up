package com.rmit.sept.bk_bookservices.bookmicroservices.service;


import com.rmit.sept.bk_bookservices.bookmicroservices.model.Book;
import com.rmit.sept.bk_bookservices.bookmicroservices.repository.BookRepository;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class BookServiceImplTest {

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
    @DisplayName("findAll: If db is empty, returns empty collection")
    void _1_findAll_collectionEmpty_emptyDB() {

        Collection<Book> allRequests = bookService.findAll();
        assertTrue(allRequests.isEmpty());

    }

    @Test
    @DisplayName("findAll: If db has one book, returns non-empty collection")
    void _2_findAll_collectionEmpty_oneBookInDB() {

        bookService.saveOrUpdate(this.bookT1);
        Collection<Book> allBooks = bookService.findAll();
        assertFalse(allBooks.isEmpty());

    }

    @Test
    @DisplayName("findAll: If db has many books, returns collection of size = db.count()")
    void _3_findAll_collectionSizeOfDB_manyBooksInDB() {

        bookService.saveOrUpdate(this.bookT2);
        bookService.saveOrUpdate(this.bookT3);
        bookService.saveOrUpdate(this.bookT4);

        Collection<Book> allBooks = bookService.findAll();
        assertFalse(allBooks.isEmpty());
    }

    @Test
    @DisplayName("findById: if id in db, returns true for is present")
    void _4_findById_isPresent_idInDB() {

        bookService.saveOrUpdate(this.bookT1);
        assertTrue(bookService.findById(this.bookT1.getId()).isPresent());

    }

    @Test
    @DisplayName("findById: if id not in db, returns false for is present")
    void _5_findById_isNotPresent_idNotInDB() {

        assertFalse(bookService.findById(11551L).isPresent());

    }

    @Test
    @DisplayName("saveorUpdateRequest: save bookto DB with correct input")
    void _6_saveorUpdateBook_success_bookInDB() {

        bookService.saveOrUpdate(this.bookT1);
        assertEquals(1, bookRepository.count());

    }

    @Test
    @DisplayName("deleteById: if book is in db, delete it")
    void _7_deleteById_success_bookInDB() {

        bookService.saveOrUpdate(this.bookT1);
        assertEquals(1, bookRepository.count());
        bookService.deleteById(this.bookT1.getId());
        assertEquals(0, bookRepository.count());

    }

    @Test
    @DisplayName("deleteById: If id does not exist, throw exception")
    void _8_deleteById_idDoesNotExists_noAction() throws EmptyResultDataAccessException {

        bookService.saveOrUpdate(this.bookT1);
        assertEquals(1, bookRepository.count());
        assertThatThrownBy(() -> {
            bookService.deleteById(100L);
        }).isInstanceOf(EmptyResultDataAccessException.class);

    }
}
