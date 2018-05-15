package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.data.entity.User;
import com.FinalProject.BookStore.data.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserJpaRepository userJpaRepository;

    //return 0 for admin, 1 for user and 2 for not found
    public Integer checkCredentials(String username, String password) {
        User toCheck = userJpaRepository.findByUsername(username);
        if(toCheck.getPassword().equals(password))
            return toCheck.getType();
        else
            return 2;
    }

    public boolean checkUsername(String username) {
        User toCheck = userJpaRepository.findByUsername(username);
        if (toCheck == null)
            return true;
        else
            return false;
    }

    public void insertUser(User user) {
        userJpaRepository.save(user);
    }
}
