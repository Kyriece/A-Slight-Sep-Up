/* custom exception for invalid usernames and passwords for login */

package com.rmit.sept.bk_loginservices.exceptions;

public class InvalidLoginResponse {

        private String username;
        private String password;

        //displays both in front end and back end
        public InvalidLoginResponse() {
            this.username = "Invalid Username";
            this.password = "Invalid Password";
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


