package com.rmit.sept.bk_loginservices.Repositories;

import com.rmit.sept.bk_loginservices.model.User;
import com.rmit.sept.bk_loginservices.services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collection;
import java.util.Iterator;
import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    final String USERNAME_CONST = "username@username.com";
    final String PASSWORD_CONST = "password";
    final String FULLNAME_CONST = "fullname";
    final String USERSTATUS_CONST = "user";

    private User user;
    private User admin;
    private User publisher;


    @BeforeAll
    void setUp() {
        user = new User("user@user.com", "fullName", "useruser", "user");
        admin = new User("admin@admin.com", "fullName", "adminadmin", "admin");
        publisher = new User("publisher@publisher.com", "fullName", "publisher", "publisher");
    }

    @AfterEach
    void afterEach() {
        userService.deleteAllUsers();
    }

    @AfterAll
    void afterAll() { userService.deleteAllUsers();}

    @Test
    @DisplayName("findByUsername: Returns user object when username exists")
    void _1_findByUsername_userObject_usernameExists() {
        User dbUser = userService.saveUser(this.user);
        User returnUser = userRepository.findByUsername(dbUser.getUsername());
        assertTrue(returnUser != null);
    }

    @Test
    @DisplayName("findByUsername: Returns null when username does not exist in database")
    void _2_findByUsername_null_usernameDoesNotExist() {
        User returnUser = userRepository.findByUsername("searchUsername");
        assertTrue(returnUser == null);

    }

    @Test
    @DisplayName("findByUsername: Returns null when null argument passed")
    void _3_findByUsername_throwsException_null(){
        User nullUser = userRepository.findByUsername(null);
        assertTrue(nullUser == null);
    }

    @Test
    @DisplayName("getById: Returns user object when id exists in the database")
    void _4_getById_userObject_IDExists(){
        User savedUser = userService.saveUser(this.user);
        long id = savedUser.getId();
        User returnUser = userRepository.getById(id);
        assertTrue(returnUser != null);
    }

    @Test
    @DisplayName("getById: Returns null when ID does not exist in database")
    void _5_getById_null_IDDoesNotExist(){
        long doesNotExist = 100704381L;
        User returnUser = userRepository.getById(doesNotExist);
        assertTrue(returnUser == null);
    }

    @Test
    @DisplayName("getById: Returns null when null argument passed")
    void _6_getById_null_null(){
        User returnUser = userRepository.getById(null);
        assertTrue(returnUser == null);
    }

    @Test
    @DisplayName("findAll: If db is empty, returns empty iterable")
    void _7_findAll_iterableEmpty_emptyDB() {

        Iterable<User> allUsers = userRepository.findAll();
        assertFalse(allUsers.iterator().hasNext());

    }

    @Test
    @DisplayName("findAll: If db has one user, returns non-empty iterable")
    void _8_findAll_iterableNotEmpty_oneUserInDB() {

        userService.saveUser(this.user);
        Iterable<User> allUsers = userRepository.findAll();
        assertTrue(allUsers.iterator().hasNext());

    }

    @Test
    @DisplayName("findAll: If db has many users, returns iterable of size = db.count()")
    void _9_findAll_iterableSizeOfDB_manyUserInDB() {

        userService.saveUser(this.user);
        userService.saveUser(this.admin);
        userService.saveUser(this.publisher);

        Iterable<User> allUsers = userRepository.findAll();
        Iterator<User> it = allUsers.iterator();

        int size;

        if (allUsers instanceof Collection) {
            size =  ((Collection<?>) allUsers).size();
        } else {
            size = 0;
            while(it.hasNext()) {
                it.next();
                size++;
            }
        }
        assertEquals(userRepository.count(), size);
    }


}
