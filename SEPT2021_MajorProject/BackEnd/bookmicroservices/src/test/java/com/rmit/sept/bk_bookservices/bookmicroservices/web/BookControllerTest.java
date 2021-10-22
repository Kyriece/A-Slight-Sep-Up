package com.rmit.sept.bk_bookservices.bookmicroservices.web;


import com.rmit.sept.bk_bookservices.bookmicroservices.model.Book;
import com.rmit.sept.bk_bookservices.bookmicroservices.service.BookServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookServiceImpl bookService;

    private Book bookOne;
    private Book bookTwo;
    private Book bookThree;

    // define constants
    final String BOOKS_PATH = "/api/books";

    @BeforeAll
    void beforeAll() {
        //create multiple extra books
    }

    @BeforeEach
    void setEach() {
        //create a book
    }

    @AfterEach
    void afterEach() {
        //delete all books
    }

    @Test
    @DisplayName("findAll(pageable, searchtext): If DB has no books. Returns isOK(200) response")
    public void _1_findAll_isOK_noBooksInDB() throws Exception {

    }

    @Test
    @DisplayName("findAll(pageable, searchtext): If DB has one book. Returns isOK(200) response")
    public void _2_findAll_isOK_oneBookInDB() throws Exception {

    }

    @Test
    @DisplayName("findAll(pageable, searchtext): If DB has many books. Returns isOK(200) response")
    public void _3_findAll_isOK_manyBooksInDB() throws Exception {

    }

    @Test
    @DisplayName("findAll(pageNumber,pageSize, sortBy, sortDir): If DB has no books. Returns isOK(200) response")
    public void _4_findAll_isOK_noBooksInDB() throws Exception {

    }

    @Test
    @DisplayName("findAll(pageNumber,pageSize, sortBy, sortDir): If DB has one book. Returns isOK(200) response")
    public void _5_findAll_isOK_oneBookInDB() throws Exception {

    }

    @Test
    @DisplayName("findAll(pageNumber,pageSize, sortBy, sortDir): If DB has many books. Returns isOK(200) response")
    public void _6_findAll_isOK_manyBooksInDB() throws Exception {

    }

    @Test
    @DisplayName("findById(id): book in db. Returns isOK(200) response")
    public void _7_findById_isOK_bookInDB() throws Exception {

    }

    @Test
    @DisplayName("findById(id): book not in db. Returns isBadRequest(400) response")
    public void _8_findById_isBadRequest_bookNotInDB() throws Exception {

    }

    @Test
    @DisplayName("save(book): correct book details. Returns isCreated(201) response")
    public void _9_save_isCreated_correctDetails() throws Exception {

    }

    @Test
    @DisplayName("save(book): incorrect book details. Returns isBadRequest(400) response")
    public void _10_save_isBadRequest_incorrectDetails() throws Exception {

    }

    @Test
    @DisplayName("update(book): book in DB. Returns isOK(200) response")
    public void _11_update_isOK_bookInDB() throws Exception {

    }

    @Test
    @DisplayName("update(book): book in DB. Returns isBadRequest(400) response")
    public void _12_update_isBadRequest_bookNotInDB() throws Exception {

    }

    @Test
    @DisplayName("deleteById(id): book exists. Returns isOK() response")
    public void _13_deleteByID_isOK_bookExists() throws Exception {

    }

    @Test
    @DisplayName("deleteById(id): book does notexist. Returns isOK() response")
    public void _14_deleteByID_isOK_bookDoesNotExist() throws Exception {

    }

    @Test
    @DisplayName("findAllLanguages(): get languages. Returns isOK() response")
    public void _15_findAllLanguages_isOK_getLanguages() throws Exception {

    }

    @Test
    @DisplayName("findAllGenres(): get genres. Returns isOK() response")
    public void _16_findAllGenress_isOK_getGenres() throws Exception {

    }




}
