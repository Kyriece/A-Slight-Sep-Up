// package com.rmit.sept.bk_requests.requests.services;

// import com.rmit.sept.bk_requests.requests.model.AdminRequests;
// import com.rmit.sept.bk_requests.requests.repository.RequestRepository;
// import org.junit.jupiter.api.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.dao.EmptyResultDataAccessException;

// import static org.assertj.core.api.Assertions.assertThatThrownBy;
// import static org.junit.Assert.*;


// import java.util.Collection;


// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// @SpringBootTest
// public class RequestServiceTest {


//     @Autowired
//     private RequestService requestService;

//     @Autowired
//     private RequestRepository requestRepository;

//     private AdminRequests requestOne;
//     private AdminRequests requestTwo;
//     private AdminRequests requestThree;

//     @BeforeAll
//     void beforeAll() {
//         requestTwo = new AdminRequests();
//         requestThree = new AdminRequests();
//     }

//     @BeforeEach
//     void setEach() {
//         requestOne = new AdminRequests();
//     }


//     @AfterEach
//     void afterEach() {
//         requestService.deleteAllRequests();
//     }

//     @AfterAll
//     void afterAll() { requestService.deleteAllRequests();}

//     @Test
//     @DisplayName("createRequest: Successfully saves request in the database")
//     void _1_createRequest_userIDEqual_request() {

//         AdminRequests testRequest = new AdminRequests();
//         AdminRequests saveRequest = requestService.createRequest(testRequest, "userstring", "requeststring");
//         AdminRequests dbRequest = requestRepository.getById(saveRequest.getId());

//         assertEquals(1, requestRepository.count());
//         assertEquals("ID is equal", saveRequest.getId(), dbRequest.getId());

//     }

//     @Test
//     @DisplayName("findAllRequests: If db is empty, returns empty collection")
//     void _2_findAllRequests_collectionEmpty_emptyDB() {

//         Collection<AdminRequests> allRequests = requestService.findAllRequests();
//         assertTrue(allRequests.isEmpty());

//     }

//     @Test
//     @DisplayName("findAllRequests: If db has one request, returns non-empty collection")
//     void _3_findAllRequests_collectionEmpty_oneRequestInDB() {

//         requestService.createRequest(this.requestOne, "userstring", "requeststring");
//         Collection<AdminRequests> allRequests = requestService.findAllRequests();
//         assertFalse(allRequests.isEmpty());

//     }

//     @Test
//     @DisplayName("findAllRequests: If db has many requests, returns collection of size = db.count()")
//     void _4_findAllRequests_collectionSizeOfDB_manyRequestsInDB() {

//         requestService.createRequest(this.requestOne, "userstring", "requeststring");
//         requestService.createRequest(this.requestTwo, "userstring", "requeststring");
//         requestService.createRequest(this.requestThree, "userstring", "requeststring");

//         Collection<AdminRequests> allRequests = requestService.findAllRequests();
//         assertEquals(requestRepository.count(), allRequests.size());

//     }

//     @Test
//     @DisplayName("saveorUpdateRequest: If db has many requests, returns collection of size = db.count()")
//     void _5_saveorUpdateRequest_success_userInDB() {

//         requestService.createRequest(this.requestOne, "userstring", "requeststring");
//         this.requestOne.setTitle("TEST_TITLE");
//         requestService.saveorUpdateRequest(this.requestOne);
//         assertEquals(1, requestRepository.count());

//     }

//     @Test
//     @DisplayName("deleteById: If id does not exist, no action")
//     void _6_deleteById_idDoesNotExists_noAction() throws EmptyResultDataAccessException {

//         requestService.createRequest(this.requestOne, "userstring", "requeststring");
//         assertEquals(1, requestRepository.count());
//         assertThatThrownBy(() -> {
//             requestService.deleteById(100L);
//         }).isInstanceOf(EmptyResultDataAccessException.class);

//     }
//     @Test
//     @DisplayName("deleteById: If id exists, delete")
//     void _7_deleteById_idExists_deleteID() {

//         requestService.createRequest(this.requestOne, "userstring", "requeststring");
// //        requestService.createRequest(this.requestTwo, "hello", "requeststring");
//         assertEquals(1, requestRepository.count());
//         requestService.deleteById(requestOne.getId());
//         assertEquals(0, requestRepository.count());

//     }

//     @Test
//     @DisplayName("deleteAllRequests: If db has no requests, no action")
//     void _8_deleteAllRequests_emptyDB_noAction() {

//         requestService.deleteAllRequests();

//     }

//     @Test
//     @DisplayName("deleteAllRequests: If db has one request, delete request")
//     void _9_deleteAllRequests_emptyDB_oneUserInDB() {

//         requestService.createRequest(this.requestOne, "userstring", "requeststring");
//         assertEquals(1, requestRepository.count());
//         requestService.deleteAllRequests();
//         assertEquals(0, requestRepository.count());

//     }

//     @Test
//     @DisplayName("deleteAllRequests: If db has many Requests, delete Requests")
//     void _10_deleteAllRequests_emptyDB_manyRequestsInDB() {

//         requestService.createRequest(this.requestOne, "userstring", "requeststring");
//         requestService.createRequest(this.requestTwo, "userstring", "requeststring");
//         requestService.createRequest(this.requestThree, "userstring", "requeststring");
//         assertEquals(3, requestRepository.count());
//         requestService.deleteAllRequests();
//         assertEquals(0, requestRepository.count());

//     }


// }
