import React, { Component } from 'react'
import Person from '../Persons/Person'
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";
import { Link } from 'react-router-dom';
import store from "../../store";


class ContactUs extends Component {

    render() {
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
