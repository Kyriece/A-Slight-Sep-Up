import React, { Component, useState } from 'react'
import Person from '../Persons/Person'
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";
import { Link } from 'react-router-dom';
import store from "../../store";
import './ContactUs.css';


class ContactUs extends Component {
//     constructor(){
//         super();

//         this.state= {
//         requestComment = ""
     
//     }; 
//     this.onChange = this.onChange.bind(this);
//     this.onSubmit = this.onSubmit.bind(this);

// }

// onChange(e){
//     this.setState({[e.target.name]: e.target.value});
// }
// onSubmit(e){
//     e.preventDefault();
//     const newPerson = {
        
//     }

//     this.props.createPerson(newPerson, this.props.history);
// }

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
                                    <p>If you have any issues, want to suggest a book for us to stock or anything else - submit a request below!</p>
                                    
                                    <p> Alternatively, send through an email to the address below. </p>
                                    <p>support@bookaroo.com.au</p>
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
