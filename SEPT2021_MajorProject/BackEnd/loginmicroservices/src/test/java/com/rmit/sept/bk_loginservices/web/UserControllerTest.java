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

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    // define constants
    final String LOGIN_POST = "/api/users/login";
    final String REGISTER_POST = "/api/users/register";
    final String USERNAME_CONST = "username@username.com";
    final String PASSWORD_CONST = "password";

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


}