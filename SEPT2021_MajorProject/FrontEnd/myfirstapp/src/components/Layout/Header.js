import React, { Component } from 'react';

import { getUser } from "../../actions/userActions";
import { logout } from "../../actions/securityActions";
import securityReducer from "../../reducers/securityReducer";

import store from "../../store";

const Header = (props) => {
    const user = store.getState().security.user
    const isLoggedIn = store.getState().security.validToken 
    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
            <div className="container">
            <a className="navbar-brand" href="/dashboard">
                Person Management Tool
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
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item">
                        <a className="nav-link" href="/dashboard">
                            Dashboard
                        </a>
                    </li>
                </ul>

                {isLoggedIn ? 
                    /* If user === true (Logged In) */
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <a className="nav-link " >
                                {user.username}
                            </a>
                        </li>
                        <li className="nav-item">
                            <div onClick={() => {
                                store.dispatch(logout());
                                window.location.href = "/";
                            }}>
                                Logout
                            </div>
                        </li>
                    </ul>
                    
                    : /* Else user === undefined (Logged Out) */
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item">
                            <a className="nav-link " href="/register">
                                Sign Up
                            </a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/login">
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
  