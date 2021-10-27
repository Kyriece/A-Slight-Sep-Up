import React, { Component } from 'react';
import { getUser } from "../../actions/userActions";
import { logout } from "../../actions/securityActions";
import securityReducer from "../../reducers/securityReducer";
import store from "../../store";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import {
  faUserPlus,
  faSignInAlt,
  faSignOutAlt,
  faUserCog,
} from "@fortawesome/free-solid-svg-icons";

const Header = (props) => {
    const user = store.getState().security.user
    const isLoggedIn = store.getState().security.validToken 
    //console.log(user)
    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
            <div className="container">
            <a className="navbar-brand" href="/dashboard">
                Bookaroo
            </a>
            <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#mobile-nav"
            >
                <span className="navbar-toggler-icon" />
            </button>

            <div className="collapse navbar-collapse" id="mobile-nav">
            {isLoggedIn ?
            <ul className="navbar-nav mr-auto">
            <li className="nav-item">
                {<a className="nav-link" href="/list"> Book List</a>}
            </li>
            <li className="nav-item">
                {user.userStatus === "admin" &&  <a className="nav-link" href="/add"> Add Book</a>}
                {user.userStatus === "publisher" &&  <a className="nav-link" href="/add"> Add Book</a>}
            </li>
            <li className="nav-item">   
                {user.userStatus === "user" &&  <a className="nav-link" href="/ContactUs"> Suggest Book </a>}
                {user.userStatus === "admin" &&  <a className="nav-link" href="/RequestManager"> Manage Requests</a>}
            </li>
            <li className="nav-item">   
                {user.userStatus === "admin" &&  <a className="nav-link" href="/UserManager"> Manage Users</a>}
            </li>
            </ul>


            :
            <ul className="navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-link" href="/dashboard">
                            Dashboard
                        </a>
                    </li>
                </ul>

            }
                

                {isLoggedIn ? 
                    /* If user === true (Logged In) */
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <a className="nav-link" href="/Profile">
                                <FontAwesomeIcon icon ={faUserCog} />
                                User Profile
                            </a>
                        </li>
                        <li className="nav-item">
                                {user.userStatus === "user" && <a className="nav-link" href="/profile"> {user.username} </a>}

                                {user.userStatus === "publisher" && <a className="nav-link" href="/ProducerBoard"> {user.username} </a>}

                                {user.userStatus === "admin" && <a className="nav-link" href="/AdminBoard"> {user.username} </a>}
                        </li>
                        <li className="nav-item">
                            <div onClick={() => {
                                store.dispatch(logout());
                                window.location.href = "/login";
                            }}>
                              <a className="nav-link">
                              <FontAwesomeIcon icon ={faSignOutAlt} />
                                Logout
                                </a>
                            </div>
                        </li>
                    </ul>
                    
                    : /* Else user === undefined (Logged Out) */
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <a className="nav-link " href="/register">
                            <FontAwesomeIcon icon={faUserPlus} />
                                Sign Up
                            </a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/login">
                                <FontAwesomeIcon icon={faSignInAlt} />
                                Login
                            </a>
                        </li>
                    </ul>
                }               
            </div>
            </div>
        </nav>
    );
  };

  export default Header
  