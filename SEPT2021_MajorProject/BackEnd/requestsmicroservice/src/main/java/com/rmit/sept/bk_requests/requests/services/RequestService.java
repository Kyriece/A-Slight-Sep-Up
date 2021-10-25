package com.rmit.sept.bk_requests.requests.services;

import com.rmit.sept.bk_requests.requests.repository.RequestRepository;

import java.util.Collection;

import com.rmit.sept.bk_requests.requests.model.AdminRequests;
import com.rmit.sept.bk_requests.requests.repository.RequestRepository;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
// create some methods for the request service
  @Autowired
	private RequestRepository requestRepository;

  public AdminRequests createRequest(AdminRequests newRequest, String userString, String requestString){
    newRequest.setUser(userString);
    newRequest.setrequestComment(requestString);
    return requestRepository.save(newRequest);
  }

	public Iterable<AdminRequests> findAllRequests() {
		return requestRepository.findAll();
	}

  public AdminRequests saveorUpdateRequest (AdminRequests request){
    return requestRepository.save(request);
  }

	public String deleteById(Long id) {
    JSONObject jsonObject = new JSONObject();
		try {
			requestRepository.deleteById(id);
			jsonObject.put("message", "request deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public void deleteAllRequests() {
		if(requestRepository.count() > 0) {
			requestRepository.deleteAll();
		}
	}
    
}
