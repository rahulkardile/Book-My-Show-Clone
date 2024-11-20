package com.lentra.BookMyShowClone.service;

import com.lentra.BookMyShowClone.entity.Users;
import com.lentra.BookMyShowClone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager manager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public boolean registerUser(Users user) {

        if ( repo.findByEmail(user.getEmail( )) == null ) {
            user.setPassword(encoder.encode(user.getPassword( )));
            user.setCreated_at(new Date( ));
            repo.save(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean verify(Users user) {

        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername( ) , user.getPassword( ))
        );

        return authentication.isAuthenticated( );
    }
}
