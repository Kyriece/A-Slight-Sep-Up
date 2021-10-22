package com.rmit.sept.bk_requests.requests.repository;

import java.util.Collection;
import java.util.Optional;

import com.rmit.sept.bk_requests.requests.model.AdminRequests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<AdminRequests, Long>{
    

    @Override
    Collection<AdminRequests> findAll();

    AdminRequests getById(Long id);
}
