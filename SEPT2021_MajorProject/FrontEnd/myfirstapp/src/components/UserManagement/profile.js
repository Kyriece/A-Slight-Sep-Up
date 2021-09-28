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
                <div class="container profile">
          <div class="column">
            <div class="col-md-4">
              <div class="profile-img">
                <img src="https://www.seekpng.com/png/detail/41-410093_circled-user-icon-user-profile-icon-png.png" alt="" />
              </div>
            </div>
          </div>
                <div>
                    <br></br>
                    <h1 className="display-4 text-center"> Username: {user.username} </h1>
                    <h1 className="display-4 text-center"> Full Name:{user.fullName} </h1>
                    <h1 className="display-4 text-center"> Publisher Request:{user.publisherRequest} </h1>
                    <h1 className="display-4 text-center"> User Status: {user.userStatus} </h1>
                </div>
                </div>
                </>
            );
        }
    }
    
    export default profile;