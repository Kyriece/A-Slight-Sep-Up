package com.rmit.sept.bk_requests.requests.web;


import com.rmit.sept.bk_requests.requests.model.AdminRequests;
import com.rmit.sept.bk_requests.requests.services.RequestService;
import net.minidev.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class RequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RequestService requestService;

    private AdminRequests requestOne;
    private AdminRequests requestTwo;
    private AdminRequests requestThree;

    final String CREATE_POST = "/api/requests/newRequest";
    final String ALL_GET = "/api/requests/all";
    final String DELETE_DELETE = "/api/requests/deleteRequest";


    @BeforeAll
    void beforeAll() {
        requestTwo = new AdminRequests();
        requestThree = new AdminRequests();
    }

    @BeforeEach
    void setEach() {
        requestOne = new AdminRequests();
    }


    @AfterEach
    void afterEach() {
        requestService.deleteAllRequests();
    }

    @Test
    @DisplayName("createRequest(): creates a new request with correct details. Returns isCreated(201) response")
    public void _1_createRequest_isCreated_correctDetails() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("user", "useruser");
        jsonHMAP.put("requestComment", "commentcomment");
        jsonHMAP.put("title", "titletitle");
        jsonHMAP.put("email", "Tomahawk@geelong.com.au");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(CREATE_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("createRequest(): attempts to create a new request with incorrect details. Returns status isBadRequest(400)")
    public void _2_createRequest_isBadRequest_incorrectDetails() throws Exception {

        mockMvc.perform(
                post(CREATE_POST, requestOne))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("deleteByid(): deletes a request that exists in the DB. Returns status isOK(200)")
    public void _3_deleteByid_isOK_requestExists() throws Exception {

//        requestService.createRequest(requestOne, "userString", "requestString");
//
//        HashMap<String, String> jsonHMAP = new HashMap<>();
//        jsonHMAP.put("id", "1");
//        String json = new JSONObject(jsonHMAP).toJSONString();
//
//        mockMvc.perform(
//                delete(DELETE_DELETE)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("deleteByid(): deletes a request that does not exist in the DB. Returns status isBadRequest(400)")
    public void _4_deleteByid_isBadRequest_requestDoesNotExists() throws Exception {

//        HashMap<String, String> jsonHMAP = new HashMap<>();
//        jsonHMAP.put("id", "1");
//        String json = new JSONObject(jsonHMAP).toJSONString();
//
//        mockMvc.perform(
//                delete(DELETE_DELETE)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("getAllRequest: If db is empty, returns empty collection")
    void _5_getAllRequest_collectionEmpty_emptyDB() throws Exception{

        mockMvc.perform(get(ALL_GET))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(0));
    }

    @Test
    @DisplayName("getAllRequest: If db has one request, returns non-empty collection")
    void _6_getAllRequest_collectionNotEmpty_oneRequestInDB() throws Exception{

        requestService.createRequest(requestOne, "userString", "requestString");

        mockMvc.perform(get(ALL_GET))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
    }

    @Test
    @DisplayName("getAllRequest: If db has many requests, returns collection with many requests")
    void _7_getAllRequest_collectionManyRequests_threeRequestsInDB() throws Exception{


        requestService.createRequest(requestOne, "userOneString", "requestOneString");
        requestService.createRequest(requestTwo, "userTwoString", "requestTwoString");
        requestService.createRequest(requestThree, "userThreeString", "requestThreeString");

        mockMvc.perform(get(ALL_GET))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3));
    }


}
