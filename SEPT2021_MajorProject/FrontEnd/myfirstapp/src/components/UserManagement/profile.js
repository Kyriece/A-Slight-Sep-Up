import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {UpdateUser} from "../../actions/userActions";
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";

import store from "../../store";

class profile extends Component{



    
        render() {
            const user = store.getState().security.user
            console.log(user);
            return (
                <>
                <Header/>
                <div>
                    <h1 className="display-4 text-center"> username: {user.username} </h1>
                    <h1 className="display-4 text-center"> fullName: {user.fullName} </h1>
                    <h1 className="display-4 text-center"> publisherRequest: {user.publisherRequest} </h1>
                    <h1 className="display-4 text-center"> userStatus: {user.userStatus} </h1>
                    <li className="nav-item">
                            <div onClick={() => {
                                console.log("test");
                                store.dispatch(UpdateUser(user.id));
                                console.log("testend");
                            }}>
                                publisherRequest
                            </div>
                        </li>
                </div>
                <Footer />
                </>
            );
        }
    }
    
    export default profile;