package org.example.user;

import org.example.common.BaseRepositoty;

public class UserRepository extends BaseRepositoty<String, User> {

    private static final UserRepository userRepository = new UserRepository();

    private UserRepository() {}

    public static UserRepository getInstance() {
        return userRepository;
    }


}
