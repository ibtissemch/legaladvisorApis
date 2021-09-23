package com.la.legaladvisor.securities;

import com.la.legaladvisor.entities.Users;
import com.la.legaladvisor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class LAUsersDetailsServices implements UserDetailsService {

    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Users users = usersService.getByUsername(userName);
        return new User(users.getName(),users.getPassword(),new ArrayList<>());
    }
}
