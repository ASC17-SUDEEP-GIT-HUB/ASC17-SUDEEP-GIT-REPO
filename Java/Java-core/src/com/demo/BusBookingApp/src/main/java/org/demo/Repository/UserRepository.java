package org.demo.Repository;

import org.demo.Model.User;

import java.util.List;

public interface UserRepository {

    boolean addUser(User user);
    User getUserByEmail(String email);
    User getUserById(String userId);
    List<User> getAllusers();

}
