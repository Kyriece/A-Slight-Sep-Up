import React, { Component, useState } from 'react'
import Person from '../Persons/Person'
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";
import { Link } from 'react-router-dom';
import store from "../../store";
import './ContactUs.css';
import { createRequests } from "../../actions/requestActions";
import * as PropTypes from 'prop-types';
import { connect } from "react-redux";


class ContactUs extends Component {
  constructor() {
    super();

    this.state = {
      id: 0,
      user: "",
      email: "Email",
      title: "Request Title",
      request_comment: "Detailed Information"
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onSubmit(e) {
    e.preventDefault();
    console.log(this.state)
    const loggedInUser = store.getState().security.user
    console.log(loggedInUser.fullName);
    this.state.user = loggedInUser.fullName;
    this.state.id = 0;
    const AdminReq = {
      id: this.state.id,
      name: this.state.user,
      email: this.state.email,
      title: this.state.title,
      request_comment: this.state.request_comment,
    };

    if(this.props.createRequests(AdminReq, this.props.history)){
      this.props.history.push("/ContactUs");
    }

    alert('You have submitted the form.')
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

    render() {

        
        return (
            <>
                <Header />
                <div className="landing">
                    <div className="light-overlay landing-inner text-dark">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-12 text-center">
                                    <h1 className="display-8 mb-4">
                                        Contact Us!
                                    </h1>
                                    <hr />
                                    <p>If you have any issues, want to suggest a book for us to stock or anything else - submit a request below!</p>
                                    
                                    <p> Alternatively, send through an email to the address below. </p>
                                    <p>support@bookaroo.com.au</p>
                                    <form onSubmit={this.onSubmit}>
                                      <fieldset>  
                                        <input className="formBox" type="text" 
                                        name="title" placeholder="Request Title"
                                                              value={this.state.title}
                                                              onChange={this.onChange}/>
                                        <input className="formBox" type="text" name="request_comment" placeholder="Request Information"
                                        value={this.state.request_comment}
                                        onChange={this.onChange}/>
                                        <input className="formBox" type="text" name="email" placeholder="Email"
                                        value={this.state.email}
                                        onChange={this.onChange}/>
                                      </fieldset>
                                      <button type="submit">Submit Request</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <Footer />
            </>
    
        )
    }
}

ContactUs.propTypes = {
  createRequests: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
  security: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  security: state.security,
  errors: state.errors
});
export default connect(
  mapStateToProps,
  { createRequests }
)(ContactUs);
