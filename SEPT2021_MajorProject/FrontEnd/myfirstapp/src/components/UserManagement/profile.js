import React, {Component} from 'react';
import {UpdateUser} from "../../actions/userActions";
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";
import store from "../../store";

class Profile extends Component {
//profile page for a user to view details about their account
  render() {
    const user = store.getState().security.user
    return (
      <>
        <Header/>
        <div className="container mt-5">
          <div className="row d-flex justify-content-center">
            <div className="col-md-7">
              <div className="card p-3 py-4">
                  <div className="text-center">
                    <svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor"
                      className="bi bi-book" viewBox="0 0 16 16">
                    <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
                    </svg>
                  </div>
                  <div className="text-center mt-3">
                    <h3 className="mt-2 mb-0"> Username: {user.username} </h3>
                    <h5 className="idd1"> Name: {user.fullName} </h5>
                    <div className="px-4 mt-1">
                    <p className="fonts"> User Status: {user.userStatus} </p></div>
                    <div className="buttons">
                      <button class="btn btn-lg btn-primary mr-2">
                        {user.userStatus === "user" &&  <div onClick={() => { store.dispatch(UpdateUser(user.id)); }}> Become a publisher </div>}   
                        {user.userStatus === "admin" &&  <div onClick={() => {  }}>  Edit Profile</div>}
                        {user.userStatus === "publisher" &&  <div onClick={() => {  }}>  Edit Profile</div>}
                      </button>
                    </div>
                  </div>
              </div>
            </div>
          </div>
        </div>
        <Footer/>
      </>
    );
  }
}
export default Profile;