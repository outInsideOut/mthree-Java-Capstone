/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.models.Role;
import com.sg.capstone.models.User;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Raluca
 */
@SpringBootTest
public class UserDaoDbTest {
    
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;
    
    public UserDaoDbTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<User> users= userDao.getAllUsers();
        for (User user : users) {
            userDao.deleteUserById(user.getId());
        }

        List<Role> roles = roleDao.getAllRoles();
        for (Role role : roles) {
            roleDao.deleteRoleById(role.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddAndGetUsers() {
        Role role = new Role();
        role.setRole("TopUser");
        role = roleDao.addRole(role);
        
        User user = new User();
        user.setUsername("Username_Test");
        user.setPassword("Password_Test");
        user.setRole(role);
        user = userDao.addUser(user);

        User fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
    }
    
    @Test
    public void testGetAllUsers() {
        Role role = new Role();
        role.setRole("TopUser");
        role = roleDao.addRole(role);
        
        User user = new User();
        user.setUsername("Username_Test");
        user.setPassword("Password_Test");
        user.setRole(role);
        user = userDao.addUser(user);
        
        User user1 = new User();
        user1.setUsername("Username_Test1");
        user1.setPassword("Password_Test1");
        user1.setRole(role);
        user1 = userDao.addUser(user1);

        List<User> users = userDao.getAllUsers();
        assertEquals(2, users.size());
        assertTrue(users.contains(user));
        assertTrue(users.contains(user1));
    }
    
    @Test
    public void testUpdateUsers() {
        Role role = new Role();
        role.setRole("TopUser");
        role = roleDao.addRole(role);
        
        User user = new User();
        user.setUsername("Username_Test");
        user.setPassword("Password_Test");
        user.setRole(role);
        user = userDao.addUser(user);

        User fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
        
        user.setUsername("NewUser_Name");
        userDao.updateUser(user);
        assertNotEquals(user, fromDao);

        fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
    }
    
}
