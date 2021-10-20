package com.rmit.sept.bk_requests.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;

import com.rmit.sept.bk_requests.model.AdminRequests;
import com.rmit.sept.bk_requests.repository.RequestRepository;
import com.rmit.sept.bk_requests.services.RequestService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/newRequest")
    public ResponseEntity<?> createRequest (@RequestBody String userName, String requestComment){

        AdminRequests newRequest = new AdminRequests(userName, requestComment);
        requestService.saveorUpdateRequest(newRequest);

        return  new ResponseEntity<AdminRequests>(newRequest, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Collection<AdminRequests> getAllRequest(Principal principle) {
        return requestService.findAllRequests();
        
    }

    @DeleteMapping("/deleteRequest")
    public ResponseEntity<String> deleteByid(long id){
        return new ResponseEntity<>(requestService.deleteById(id), HttpStatus.OK);
    }
    
}
