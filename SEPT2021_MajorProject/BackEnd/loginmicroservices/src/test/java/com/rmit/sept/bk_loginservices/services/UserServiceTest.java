// package com.rmit.sept.bk_loginservices.services;

// import com.rmit.sept.bk_loginservices.Repositories.UserRepository;
// import com.rmit.sept.bk_loginservices.exceptions.UsernameAlreadyExistsException;
// import com.rmit.sept.bk_loginservices.model.User;
// import org.junit.jupiter.api.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import java.util.Collection;
// import java.util.Iterator;
// import static org.assertj.core.api.Assertions.assertThatThrownBy;
// import static org.junit.Assert.*;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// @SpringBootTest
// public class UserServiceTest {

//     @Autowired
//     private UserService userService;

//     @Autowired
//     private UserRepository userRepository;

//     final String USERNAME_CONST = "username@username.com";
//     final String PASSWORD_CONST = "password";
//     final String FULLNAME_CONST = "fullname";
//     final String USERSTATUS_CONST = "user";

//     private User user;
//     private User admin;
//     private User publisher;


//     @BeforeAll
//     void setUp() {
//         user = new User("user@user.com", "fullName", "useruser", "user");
//         admin = new User("admin@admin.com", "fullName", "adminadmin", "admin");
//         publisher = new User("publisher@publisher.com", "fullName", "publisher", "publisher");
//     }

//     @AfterEach
//     void afterEach() {
//         userService.deleteAllUsers();
//     }

//     @AfterAll
//     void afterAll() { userService.deleteAllUsers();}

//     @Test
//     @DisplayName("saveUser: Successfully saves an admin in the database")
//     void _1_saveUser_userAttributesEqual_admin() {
//         User saveUser = userService.saveUser(this.admin);
//         User dbUser = userRepository.findByUsername(saveUser.getUsername());

//         assertEquals(1, userRepository.count());
//         assertEquals("ID is equal", saveUser.getId(), dbUser.getId());
//         assertEquals("Username is equal", saveUser.getUsername(), dbUser.getUsername());
//         assertEquals("Fullname is equal", saveUser.getFullName(), dbUser.getFullName());
//         assertEquals("Userstatus is equal", saveUser.getUserStatus(), dbUser.getUserStatus());
//         assertEquals("AccountEnabled is equal", saveUser.getUsername(), dbUser.getUsername());
//     }

//     @Test
//     @DisplayName("saveUser: Successfully saves a publisher in the database")
//     void _2_saveUser_userAttributesEqual_publisher() {
//         User saveUser = userService.saveUser(this.publisher);
//         User dbUser = userRepository.findByUsername(saveUser.getUsername());

//         assertEquals(1, userRepository.count());
//         assertEquals("ID is equal", saveUser.getId(), dbUser.getId());
//         assertEquals("Username is equal", saveUser.getUsername(), dbUser.getUsername());
//         assertEquals("Fullname is equal", saveUser.getFullName(), dbUser.getFullName());
//         assertEquals("Userstatus is equal", saveUser.getUserStatus(), dbUser.getUserStatus());
//         //assertEquals("CreateDate is equal", saveUser.getCreate_At(), dbUser.getCreate_At());
//         assertEquals("AccountEnabled is equal", saveUser.getUsername(), dbUser.getUsername());
//     }

//     @Test
//     @DisplayName("saveUser: Successfully saves a user in the database")
//     void _3_saveUser_userAttributesEqual_user() {
//         User saveUser = userService.saveUser(this.user);
//         User dbUser = userRepository.findByUsername(saveUser.getUsername());

//         assertEquals(1, userRepository.count());
//         assertEquals("ID is equal", saveUser.getId(), dbUser.getId());
//         assertEquals("Username is equal", saveUser.getUsername(), dbUser.getUsername());
//         assertEquals("Fullname is equal", saveUser.getFullName(), dbUser.getFullName());
//         assertEquals("Userstatus is equal", saveUser.getUserStatus(), dbUser.getUserStatus());
//         //assertEquals("CreateDate is equal", saveUser.getCreate_At(), dbUser.getCreate_At());
//         assertEquals("AccountEnabled is equal", saveUser.getUsername(), dbUser.getUsername());
//     }

//     @Test
//     @DisplayName("saveUser: Throws username already exists exception when null passed as arg")
//     void _4_saveUser_throwsException_null() throws NullPointerException{

//         assertThatThrownBy(() -> {
//             userService.saveUser(null);
//         }).isInstanceOf(NullPointerException.class);

//     }

//     @Test
//     @DisplayName("saveUser: Throws username already exists exception when username already exists in db")
//     void _5_saveUser_throwsException_duplicateUsername() throws UsernameAlreadyExistsException{

//         userService.saveUser(this.user);

//         assertThatThrownBy(() -> {
//             userService.saveUser(this.user);
//         }).isInstanceOf(UsernameAlreadyExistsException.class).hasMessage("Username 'user@user.com' already exists");

//     }

//     @Test
//     @DisplayName("findAllUsers: If db is empty, returns empty iterable")
//     void _6_findAllUsers_iterableEmpty_emptyDB() {

//         Iterable<User> allUsers = userService.findAllUsers();
//         assertFalse(allUsers.iterator().hasNext());

//     }

//     @Test
//     @DisplayName("findAllUsers: If db has one user, returns non-empty iterable")
//     void _7_findAllUsers_iterableNotEmpty_oneUserInDB() {

//         userService.saveUser(this.user);
//         Iterable<User> allUsers = userService.findAllUsers();
//         assertTrue(allUsers.iterator().hasNext());

//     }

//     @Test
//     @DisplayName("findAllUsers: If db has many users, returns iterable of size = db.count()")
//     void _8_findAllUsers_iterableSizeOfDB_manyUserInDB() {

//         userService.saveUser(this.user);
//         userService.saveUser(this.admin);
//         userService.saveUser(this.publisher);

//         Iterable<User> allUsers = userService.findAllUsers();
//         Iterator<User> it = allUsers.iterator();

//         int size;

//         if (allUsers instanceof Collection) {
//             size =  ((Collection<?>) allUsers).size();
//         } else {
//             size = 0;
//             while(it.hasNext()) {
//                 it.next();
//                 size++;
//             }
//         }
//         assertEquals(userRepository.count(), size);
//     }

//     @Test
//     @DisplayName("deleteAllUsers: If db has no users, no action")
//     void _9_deleteAllUsers_emptyDB_emptyDB() {

//         userService.deleteAllUsers();

//     }

//     @Test
//     @DisplayName("deleteAllUsers: If db has one user, delete user")
//     void _10_deleteAllUsers_emptyDB_oneUserInDB() {

//         userService.saveUser(this.user);
//         assertEquals(1, userRepository.count());
//         userService.deleteAllUsers();
//         assertEquals(0, userRepository.count());

//     }

//     @Test
//     @DisplayName("deleteAllUsers: If db has many users, delete users")
//     void _11_deleteAllUsers_emptyDB_manyUserInDB() {

//         userService.saveUser(this.user);
//         userService.saveUser(this.admin);
//         userService.saveUser(this.publisher);
//         assertEquals(3, userRepository.count());
//         userService.deleteAllUsers();
//         assertEquals(0, userRepository.count());

//     }

// }