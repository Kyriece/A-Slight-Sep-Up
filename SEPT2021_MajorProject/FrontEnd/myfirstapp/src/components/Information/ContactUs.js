import React, { Component, useState } from 'react'
import Person from '../Persons/Person'
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";
import { Link } from 'react-router-dom';
import store from "../../store";
import './ContactUs.css';


class ContactUs extends Component {

    render() {

      const handleSubmit = event => {
        event.preventDefault();
        alert('You have submitted the form.')
      }
        const user = store.getState().security.user
        console.log(user);
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
                                    <p>If you have any issues, send through an email to the address below. Please expect a 24-48 hour reply period. Thank you for your patience.</p>
                                    <p>support@bookaroo.com.au</p>
                                    <p> alternatively, submit a request below! </p>
                                    <form onSubmit={handleSubmit}>
                                      <fieldset>  
                                        <input className="formBox" type="text" name="name" placeholder="Request Title"/>
                                        <input className="formBox" type="text" name="info" placeholder="Request Information"/>
                                        <input className="formBox" type="text" name="email" placeholder="Email"/>
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
export default ContactUs;
