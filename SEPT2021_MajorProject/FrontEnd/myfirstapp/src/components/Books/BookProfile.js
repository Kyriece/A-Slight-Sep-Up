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
           
           
            // this.props.fetchBook(id);
            // let book = this.props.book;
            // console.log(book);
            return (
                
                <>
                <Header />
                <div class="container profile" style={{paddingBottom: '400px'}}>
                    <div class="column" >
                        <div class="col-md-4">
                            <div style={{ paddingRight: '50px', float: 'left', width: '300px' }}>
                                <img src={this.state.coverPhotoURL} alt="" style={{height: '100%'}} />
                            </div>
                        </div>
                    </div>
                    <div style={{ paddingLeft: '20px', float:'left', width:'790px', height:'100%' }}>
                        <br></br>
                        <h1 className="display-4 text-center"> {this.state.title}</h1>
                        <div></div>
                        <p1 className="display-8 text-center" >{this.state.blurb}</p1>
                    </div>
                </div>
                <div class="container profile" >
                    <div class = "column">
                        <div class="col-md-4" style={{ float:'left', width: '300px'}}>
                            <h3 >Rating: {this.state.rating}/5</h3>
                            <div className="btn btn-lg btn-secondary mr-2">
                            <PayPalButtons style={{ layout: "horizontal" }} />
                            Buy Now: ${this.state.price}
                            </div>
                        </div>
                    </div>
                    <div> 
                        <h3 style={{ float:"left", width: '790px'}}> Genre: {this.state.genre}<br /> Language: {this.state.language}<br /> Author: {this.state.author} </h3>
                    </div>
                </div>
                <br /><br />
                <div class="container profile">
                    <div class = "column">
                        <div class="col-md-4" style={{ float:'left', width: '300px', paddingRight: "30px"}}> 
                            <h3>About the Author</h3>
                            <p >{this.state.authorDescription}</p>
                        </div>
                    </div>
                    <div style={{ float:"left", width: '600px'}}>
                    <h3> Table of contents <br></br>  </h3>
                    <p>{this.state.tableOfContents}</p>
                    </div>
                </div>
                <Footer />
            </>
        );
    }
}

  


export default BookProfile