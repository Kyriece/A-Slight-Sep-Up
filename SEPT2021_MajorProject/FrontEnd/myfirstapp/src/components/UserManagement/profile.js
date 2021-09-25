import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getUser} from "../../actions/userActions";
import Header from "../Layout/Header";
import store from "../../store";

class profile extends Component{
        render() {
            const user = store.getState().security.user
            console.log(user);
            return (
                <>
                <Header/>
                <div>
                    <h1 className="display-4 text-center"> {user.username} </h1>
                    <h1 className="display-4 text-center"> {user.fullName} </h1>
                    <h1 className="display-4 text-center"> {user.publisherRequest} </h1>
                    <h1 className="display-4 text-center"> {user.userStatus} </h1>
                </div>
                </>
            );
        }
    }
    
    export default profile;