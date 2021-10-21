package com.rmit.sept.bk_loginservices.web;

import com.rmit.sept.bk_loginservices.model.UserBookListing;
import com.rmit.sept.bk_loginservices.services.UserBookListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/listings")
public class ListingController {

    @Autowired
    private UserBookListingService userBookListingService;

    @PostMapping("/newListing")
    public ResponseEntity<?> createListing (@RequestBody UserBookListing userBookListing) {
        UserBookListing newUserBookListing = userBookListing;
        userBookListingService.saveOrUpdate(newUserBookListing);

        return new ResponseEntity<>(newUserBookListing, HttpStatus.CREATED);
    }

    @GetMapping("/allUserListings")
    public Collection<UserBookListing> getAllListings(Principal principal) {
        return userBookListingService.findAllUserBookListings();
    }

    @GetMapping("/getListingsByUserId")
    public Collection<UserBookListing> getListingsByUserId(long id) {
        return userBookListingService.findByUserID(id);
    }

    @DeleteMapping("/deleteListing")
    public ResponseEntity<String> deleteById(long id) {
        return new ResponseEntity<String>(userBookListingService.deleteById(id), HttpStatus.OK);
    }
}