package com.rmit.sept.bk_loginservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Collection;


@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Username needs to be an email")
    @NotBlank(message = "username is required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Please enter your full name")
    private String fullName;
    @NotBlank(message = "Password field is required")
    private String password;
    private String userstatus;
    @Transient
    private String confirmPassword;
    private Date create_At;
    private Date update_At;
    private boolean publisherrequest;
    // account locking/enabling
    private boolean accountNonLocked;
    private boolean accountEnabled;
    private Date lockTime;

    //OneToMany with Project

    public User() {
    }

    public User(String username, String fullName, String password, String userstatus) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.userstatus = userstatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getCreate_At() {
        return create_At;
    }

    public void setCreate_At(Date create_At) {
        this.create_At = create_At;
    }

    public Date getUpdate_At() {
        return update_At;
    }

    public void setUpdate_At(Date update_At) {
        this.update_At = update_At;
    }

    public Boolean getpublisherrequest() {
        return publisherrequest;
    }

    public void setpublisherrequest(boolean publisherrequest){
        this.publisherrequest = publisherrequest;
    }

    @PrePersist
    protected void onCreate(){

        this.create_At = new Date();
        this.accountNonLocked = true;
        if (!this.userstatus.equals("publisher")) {
            this.accountEnabled = true;
        }
    }

    @PreUpdate
    protected void onUpdate(){
        this.update_At = new Date();
    }

    public String getUserStatus(){
        return userstatus;
    }

    public void setUserStatus(String userstatus){
    this.userstatus = userstatus;
    }

    public void setAccountNonLocked(boolean accountNonLocked) { this.accountNonLocked = accountNonLocked;}

    public boolean isAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    /*
    UserDetails interface methods
     */

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return this.accountEnabled;
    }
}