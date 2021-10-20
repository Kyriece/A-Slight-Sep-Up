package com.rmit.sept.bk_requests.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class AdminRequests {
    @Id
	@GeneratedValue
	private Long id;

    @Column(nullable = false)
	private String user;

    @Column(nullable = false)
	private String requestComment;

	public AdminRequests() {
    }

    public AdminRequests(String user, String requestComment) {
        this.user = user;
        this.requestComment = requestComment;
    }

    public void setId(Long id) {
		this.id = id;
    }

    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

    public String getRequestComment() {
		return requestComment;
	}

	public void setrequestComment(String requestComment) {
		this.requestComment = requestComment;
	}



}
