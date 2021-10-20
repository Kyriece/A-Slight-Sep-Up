package com.rmit.sept.bk_requests.services;

import com.rmit.sept.bk_requests.repository.RequestRepository;

import java.util.Collection;

import com.rmit.sept.bk_requests.model.Requests;
import com.rmit.sept.bk_requests.repository.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
	private RequestRepository requestRepository;

	public Collection<Requests> findAllRequests() {
		return requestRepository.findAll();
	}

    public Requests saveorUpdateUser (Requests request){
        return requestRepository.save(request);
    }

    public Requests 
    
}
