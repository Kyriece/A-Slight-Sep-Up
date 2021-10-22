package com.rmit.sept.bk_requests.requests.model;

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

    @Column
	private String user;

    @Column
	private String requestComment;

	@Column
	private String title;

	@Column 
	private String email;

	public AdminRequests() {
    }

    public AdminRequests(String user, String requestComment, String title, String email) {
        this.user = user;
        this.requestComment = requestComment;
		this.title = title;
		this.email = email;
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

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}



}
