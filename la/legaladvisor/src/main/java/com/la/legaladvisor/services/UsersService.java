package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.Courts;
import com.la.legaladvisor.entities.Users;
import com.la.legaladvisor.repositories.CourtRepository;
import com.la.legaladvisor.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAll(){
        return (List<Users>) usersRepository.findAll();
    }


    public Users getByUsername(String username) {
        return usersRepository.findByName(username);
    }

    public Users createOrUpdateCourt(Users user) {
        return  usersRepository.save(user);
    }

    public void deleteCourt(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        usersRepository.delete(users.get());
    }
}
