import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import Header from "../Layout/Header";
import { Link} from "react-router-dom";
import store from '../../store';
import axios from 'axios';
import {PayPalButtons} from '@paypal/react-paypal-js';

import Footer from "../Layout/Footer"

import { getBookbyId } from "../../actions/bookActions";


class BookProfile extends Component{
//fetches the book info from the database
    constructor(){
        super();
        this.state = this.initialState;
        console.log(this.state)

    }

    initialState = {
        id: "",
        title: "",
        author: "",
        coverPhotoURL: "",
        isbnNumber: "",
        price: "",
        language: "",
        genre: "",
        blurb: "",
        authorDescription: "",
        rating: "",
        tableOfContents: "",
      };

    componentWillMount(){
        axios.get("http://localhost:8081/api/books/" + this.props.match.params.id).then(result => {
          this.setState({
            id:result.data.id,
            title:result.data.title,
            author:result.data.author,
            coverPhotoURL:result.data.coverPhotoURL,
            isbnNumber:result.data.isbnNumber,
            price:result.data.price,
            language:result.data.language,
            genre:result.data.genre,
            blurb:result.data.blurb,
            authorDescription:result.data.authorDescription,
            rating:result.data.rating,
            tableOfContents:result.data.tableOfContents
          });
        });

      }


        render() {
            console.log(this.state)


            // renders the page with the information of the book
            return (

                <>
                <Header />
                <div class="col-md-6 border-end" >
                    <div class="column" >
                        <div class="col-md-4">
                            <div style={{ paddingRight: '50px', float: 'left', width: '300px' }}>
                                <img src={this.state.coverPhotoURL} alt="" style={{height: '100%'}} />
                            </div>
                        </div>
                    </div>
                </div>

<div className="col-md-6">
    <div className="p-3 right-side">
                    <div className= "d-flex justify-content-between align-items-center">
                        <h3 className="display-4 text-center"> {this.state.title} </h3>
                    </div>

                        <div className="mt-2 pr-3 content">
                        <p1>{this.state.blurb}</p1>
                        </div>
        <div>
            <h6 style={{ float:"left", width: '790px'}}> Genre: {this.state.genre}<br /> Language: {this.state.language}<br /> Author: {this.state.author} </h6>
        </div>




                <div class="container profile" >
                    <div class = "column">
                        <div class="ratings d-flex flex-row align-items-center">
                            <h6>Rating: {this.state.rating}/5</h6>
                        </div>
                        <div className="btn btn-lg btn-primary mr-2">
                            <PayPalButtons style={{ layout: "horizontal" }} />
                            Buy Now: ${this.state.price}
                        </div>
                    </div>
                </div>
        <br></br>
        <div className="row row-cols-1 row-cols-md-3">
            <div className="col mb-4">
        <div className="card" style={{width: '18rem'}}>
            <h3 class="card-header" > Table of contents <br></br>  </h3>
            <p>{this.state.tableOfContents}</p>
        </div>
            </div>
        </div>

    </div>
</div>

        <hr />



                <div class="col-sm-6">
                    <div class = "card">

                            <h3 class="card-header">About the Author</h3>
                            <div className="card-body">
                            <p>{this.state.authorDescription}</p>
                            </div>

                    </div></div>




                <Footer />
            </>
        );
    }
}




export default BookProfile