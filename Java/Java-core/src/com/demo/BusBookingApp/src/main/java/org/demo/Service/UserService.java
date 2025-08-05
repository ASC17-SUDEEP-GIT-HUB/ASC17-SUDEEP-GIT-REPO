package org.demo.Service;

import org.demo.Model.User;

public interface UserService {

    boolean registerUser(User user);
    User loginUser(String email, String password);
    User getProfile(String userId);
}
