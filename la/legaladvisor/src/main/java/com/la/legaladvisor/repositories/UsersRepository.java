package com.la.legaladvisor.repositories;

import com.la.legaladvisor.entities.Courts;
import com.la.legaladvisor.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long> {

    Users findByNameAndPassword(String name, String password);
    Users findByName(String name);
}
