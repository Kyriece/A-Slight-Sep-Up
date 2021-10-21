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

  @Column(nullable = false)
	private String user;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
	private String requestComment;

  @Column(nullable = false)
	private String title;

	public AdminRequests() {
  }

  public AdminRequests(String user, String requestComment, String email, String title) {
    this.user = user;
    this.requestComment = requestComment;
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

    public void setEmail(String email) {
      this.email = email;
    }

    public String getEmail() {
      return email;
    }


    public String getRequestComment() {
		return requestComment;
	}

	public void setrequestComment(String requestComment) {
		this.requestComment = requestComment;
	}

    public void setTitle(String title) {  
      this.title = title;
    }

    public String getTitle() {
      return title;
    }

}
