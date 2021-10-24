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
      email: "",
      title: "",
      requestComment: ""
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onSubmit(e) {
    e.preventDefault();

    const curUser = store.getState().security.user 

    const AdminReq = {
      user: curUser.fullName,
      ...this.state
    };

    this.props.createRequests(AdminReq, this.props.history);
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
                                        <input className="formBox" type="text" 
                                        name="requestComment" placeholder="Request Information"
                                        value={this.state.requestComment}
                                        onChange={this.onChange}/>
                                        <input className="formBox" type="text" 
                                        name="email" placeholder="Email"
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
  createRequests: PropTypes.func.isRequired
};

export default connect(
  null,
  { createRequests }
)(ContactUs);
