package com.rmit.sept.bk_loginservices.web;

import com.rmit.sept.bk_loginservices.model.User;
import com.rmit.sept.bk_loginservices.services.UserService;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    private User userOne;
    private User userTwo;
    private User userThree;

    // define constants
    final String LOGIN_POST = "/api/users/login";
    final String REGISTER_POST = "/api/users/register";
    final String ALL_GET = "/api/users/all";
    final String USERNAME_CONST = "username@username.com";
    final String PASSWORD_CONST = "password";

    @BeforeAll
    void beforeAll() {
        userTwo = new User("usertwo@usertwo.com", "fullnameuser", "usertwotwo", "user");
        userThree = new User("userthree@userthree.com", "userthree", "userthree", "user");
    }

    @BeforeEach
    void setEach() {
        userOne = new User(USERNAME_CONST, "fullName", PASSWORD_CONST, "user");
    }


    @AfterEach
    void afterEach() {
        userService.deleteAllUsers();
    }

    @Test
    @DisplayName("registerUser: Registers a new admin with correct details. Returns isCreated(201) response")
    public void _1_registerUser_isCreated_correctInputAdmin() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011");
        jsonHMAP.put("confirmPassword", "sausages2011");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("registerUser: Registers a new admin with correct details. Returns isCreated(201) response")
    public void _2_registerUser_isCreated_correctInputPublisher() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "steviejsuperstar@gws.com.au");
        jsonHMAP.put("fullName", "Steve Johnson");
        jsonHMAP.put("password", "tickets07");
        jsonHMAP.put("confirmPassword", "tickets07");
        jsonHMAP.put("userStatus", "publisher");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("registerUser: Registers a new admin with correct details. Returns isCreated(201) response")
    public void _3_registerUser_isCreated_correctInputUser() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "175102@barwonprison.gov.au");
        jsonHMAP.put("fullName", "Mark Bomber Thompson");
        jsonHMAP.put("password", "ididntdoit");
        jsonHMAP.put("confirmPassword", "ididntdoit");
        jsonHMAP.put("userStatus", "user");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("registerUser: attempts to register username that already exists. Returns status isBadRequest(400)")
    public void _4_registerUser_isBadRequest_usernameAlreadyExists() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011");
        jsonHMAP.put("confirmPassword", "sausages2011");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        // register user
        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));

        //attempt registration of user again
        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerUser: attempts to register without a fullName. Returns status isBadRequest(400)")
    public void _5_registerUser_isBadRequest_missingFullName() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "");
        jsonHMAP.put("password", "sausages2011");
        jsonHMAP.put("confirmPassword", "sausages2011");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerUser: attempts to register without a username. Returns status isBadRequest(400)")
    public void _6_registerUser_isBadRequest_missingUsername() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011");
        jsonHMAP.put("confirmPassword", "sausages2011");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerUser: attempts to register without a password. Returns status isBadRequest(400)")
    public void _7_registerUser_isBadRequest_missingPassword() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "");
        jsonHMAP.put("confirmPassword", "sausages2011");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerUser: attempts to register without a confirmPassword. Returns status isBadRequest(400)")
    public void _8_registerUser_isBadRequest_missingConfirmPassword() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011");
        jsonHMAP.put("confirmPassword", "");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerUser: Register without a role. Returns isCreated(201) response")
    public void _9_registerUser_isBadRequest_missingRole() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011");
        jsonHMAP.put("confirmPassword", "sausages2011");
        jsonHMAP.put("userStatus", "");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("registerUser: attempts to register but password and confirm password don't match. Returns status isBadRequest(400)")
    public void _10_registerUser_isBadRequest_passwordsDontMatch() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011");
        jsonHMAP.put("confirmPassword", "wrongPassword");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerUser: attempts to register but password greater than 19 characters. Returns status isBadRequest(400)")
    public void _11_registerUser_isBadRequest_passwordTooLong() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "Tomahawk@geelong.com.au");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011sausages");
        jsonHMAP.put("confirmPassword", "sausages2011sausages");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("registerUser: attempts to register but password greater than 19 characters. Returns status isBadRequest(400)")
    public void _12_registerUser_isBadRequest_passwordTooLong() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "TomahawkTOMTOM");
        jsonHMAP.put("fullName", "Tom Hawkins");
        jsonHMAP.put("password", "sausages2011sausages");
        jsonHMAP.put("confirmPassword", "sausages2011sausages");
        jsonHMAP.put("userStatus", "admin");

        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(REGISTER_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("authenticateUser: Successful login with correct details. Returns status isOk(200)")
    public void _13_authenticateUser_isOK_correctLoginDetails() throws Exception {

        //create user in DB
        userService.saveUser(userOne);

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "username@username.com");
        jsonHMAP.put("password", "password");
        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(LOGIN_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("authenticateUser: Unsuccessful login with incorrect Username. Returns status isUnauthorized(401)")
    public void _14_authenticateUser_isUnauthorized_incorrectUsername() throws Exception {

        //create user in DB
        userService.saveUser(userOne);

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", "wrongUsername");
        jsonHMAP.put("password", PASSWORD_CONST);
        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(LOGIN_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("authenticateUser: Unsuccessful login with incorrect Password. Returns status isUnauthorized(401)")
    public void _15_authenticateUser_isUnauthorized_incorrectPassword() throws Exception {

        //create user in DB
        userService.saveUser(userOne);

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", USERNAME_CONST);
        jsonHMAP.put("password", "wrongPassword");
        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(LOGIN_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("authenticateUser: Unsuccessful login, no user exists in DB. Returns status isUnauthorized(401)")
    public void _16_authenticateUser_isUnauthorized_incorrectPassword() throws Exception {

        HashMap<String, String> jsonHMAP = new HashMap<>();
        jsonHMAP.put("username", USERNAME_CONST);
        jsonHMAP.put("password", PASSWORD_CONST);
        String json = new JSONObject(jsonHMAP).toJSONString();

        mockMvc.perform(
                post(LOGIN_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("getAllUsers: If db is empty, returns empty iterable")
    void _17_getAllUsers_iterableEmpty_emptyDB() throws Exception{

        mockMvc.perform(get(ALL_GET))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(0));
    }

    @Test
    @DisplayName("getAllUsers: If db has one user, returns non-empty iterable")
    void _18_getAllUsers_iterableNotEmpty_oneUserInDB() throws Exception{

        userService.saveUser(userOne);

        mockMvc.perform(get(ALL_GET))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
    }

    @Test
    @DisplayName("getAllUsers: If db has many users, returns iterable with many users")
    void _19_getAllUsers_iterableManyUsers_oneUserInDB() throws Exception{

        userService.saveUser(this.userOne);
        userService.saveUser(this.userTwo);
        userService.saveUser(this.userThree);

        mockMvc.perform(get(ALL_GET))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3));
    }

}