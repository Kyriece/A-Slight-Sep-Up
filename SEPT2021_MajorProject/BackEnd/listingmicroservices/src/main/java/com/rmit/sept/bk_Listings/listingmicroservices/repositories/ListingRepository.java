package com.rmit.sept.bk_loginservices.Repositories;

import com.rmit.sept.bk_loginservices.model.UserBookListing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface ListingRepository extends CrudRepository<UserBookListing, Long> {

    UserBookListing getById(Long id);

    //TBC
    UserBookListing getByBookID(long id);

    @Override
    Collection<UserBookListing> findAll();

    Collection<UserBookListing> getByuserID(long userID);

}
