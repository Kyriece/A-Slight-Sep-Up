package com.rmit.sept.bk_loginservices.services;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.rmit.sept.bk_loginservices.Repositories.UserBookListingRepository;
import com.rmit.sept.bk_loginservices.model.UserBookListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserBookListingService {

    @Autowired
    private UserBookListingRepository userBookListingRepository;

    public UserBookListing saveOrUpdate(UserBookListing newUserBookListing) {
        return userBookListingRepository.save(newUserBookListing);
    }

    public UserBookListing findByID(Long id){
        return userBookListingRepository.getById(id);
    }

    public Collection<UserBookListing> findByUserID(Long id){
        return userBookListingRepository.getByuserID(id);
    }

    public Collection<UserBookListing> findAllUserBookListings() {
        return userBookListingRepository.findAll();
    }

    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            userBookListingRepository.deleteById(id);
            jsonObject.put("message", "Book deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
