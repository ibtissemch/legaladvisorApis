package com.la.legaladvisor.repositories;

import com.la.legaladvisor.entities.Courts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CourtRepository extends CrudRepository<Courts,Long> {


}
