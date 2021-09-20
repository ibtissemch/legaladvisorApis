/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.repositories;

import com.la.legaladvisor.entities.Supporters;
import com.la.legaladvisor.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository

public interface UsersRepository extends CrudRepository<Users,Long> {


}