package com.rmit.sept.bk_requests.requests.repository;

import com.rmit.sept.bk_requests.requests.model.AdminRequests;
import com.rmit.sept.bk_requests.requests.services.RequestService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.Assert.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class RequestRepositoryTest {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestRepository requestRepository;

    private AdminRequests requestFourty;
    private AdminRequests requestTwenty;
    private AdminRequests requestSeven;
    private AdminRequests requestFour;

    @BeforeAll
    void beforeAll() {
        requestSeven = new AdminRequests();
        requestTwenty = new AdminRequests();
        requestFour = new AdminRequests();
    }

    @BeforeEach
    void setEach() {
        requestFourty = new AdminRequests();
    }


    @AfterEach
    void afterEach() {
        requestService.deleteAllRequests();
    }

    @AfterAll
    void afterAll() { requestService.deleteAllRequests();}


    @Test
    @DisplayName("findAllRequests: If db is empty, returns empty collection")
    void _1_findAllRequests_collectionEmpty_emptyDB() {

        Collection<AdminRequests> allRequests = requestRepository.findAll();
        assertTrue(allRequests.isEmpty());

    }

    @Test
    @DisplayName("findAllRequests: If db has one request, returns non-empty collection")
    void _2_findAllRequests_collectionEmpty_oneRequestInDB() {

        requestService.createRequest(this.requestFourty, "userstring", "requeststring");
        Collection<AdminRequests> allRequests = requestRepository.findAll();
        assertFalse(allRequests.isEmpty());

    }

    @Test
    @DisplayName("findAllRequests: If db has many requests, returns collection of size = db.count()")
    void _3_findAllRequests_collectionSizeOfDB_manyRequestsInDB() {

        requestService.createRequest(this.requestSeven, "userstring", "requeststring");
        requestService.createRequest(this.requestTwenty, "userstring", "requeststring");
        requestService.createRequest(this.requestFour, "userstring", "requeststring");

        Collection<AdminRequests> allRequests = requestRepository.findAll();
        assertEquals(requestRepository.count(), allRequests.size());

    }
}
