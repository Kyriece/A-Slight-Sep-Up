package com.rmit.sept.bk_loginservices.exceptions;

public class InvalidLoginResponse {

        private String username;
        private String password;

        public InvalidLoginResponse() {
            this.username = "Invalid Username 8080";
            this.password = "Invalid Password 8080";
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


