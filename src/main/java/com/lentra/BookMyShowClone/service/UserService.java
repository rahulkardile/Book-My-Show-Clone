package com.lentra.BookMyShowClone.service;

import com.lentra.BookMyShowClone.entity.Users;
import com.lentra.BookMyShowClone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public boolean registerUser(Users user) {

        if (repo.findByEmail(user.getEmail( )) == null) {
            user.setPassword(encoder.encode(user.getPassword( )));
            user.setCreated_at(new Date());
            repo.save(user);
            return true;
        } else {
            return false;
        }
    }

}
