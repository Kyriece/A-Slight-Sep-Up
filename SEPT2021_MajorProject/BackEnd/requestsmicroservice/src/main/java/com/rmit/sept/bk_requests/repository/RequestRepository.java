package com.rmit.sept.bk_requests.repository;

import java.util.Collection;

import com.rmit.sept.bk_requests.model.Requests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Requests, Long>{
    

    @Override
    Collection<Requests> findAll();
    
}
