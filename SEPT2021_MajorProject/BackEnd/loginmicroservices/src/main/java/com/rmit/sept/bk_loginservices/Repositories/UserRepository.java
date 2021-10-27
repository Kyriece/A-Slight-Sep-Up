package com.rmit.sept.bk_loginservices.Repositories;

import com.rmit.sept.bk_loginservices.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*default crud repository that provides inbuilt methods for database manipulation*/

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User getById(Long id);

    //void setThepublisherrequest(boolean publisherrequest);

    @Override
    Iterable<User> findAll();

    Iterable<User> getBypublisherrequest(Boolean request);
}
