import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import Header from "../Layout/Header";
import { Link } from "react-router-dom";

class BookProfile extends Component{
        render() {
            return (
                <>
                <Header />
                <div class="container profile">
                    <div class="column" >
                        <div class="col-md-4">
                            <div class="profile-img" style={{ paddingRight: '50px' }}>
                                <img src="https://media.istockphoto.com/vectors/closed-book-icon-vector-id108613723?k=6&m=108613723&s=170667a&w=0&h=mTPlOsrR-Z0adqiRMeTefxmLBY2KPYxZG5Z8ngMcM-s=" alt="" />
                            </div>
                        </div>
                    </div>
                    <div style={{ paddingLeft: '20px' }}>
                        <br></br>
                        <h1 className="display-4 text-center"> Book Title Here  </h1>
                        <div></div>
                        <p1 className="display-8 text-center"> A blurb is a short description of a book that is written for promotional purposes. Traditionally, it would be found on the inside back cover of a hardback. As paperback publishing developed, readers began seeing the blurb appearing on the back cover. Generally, 150-200 words are more than enough for a full blurb.
                            In the modern publishing landscape, where more books are being purchased online than in bricks and mortar stores, you are more likely to encounter blurbs on the product page of Amazon or any other digital retailer. Sometimes, you will hear them referred to as ‘book descriptions.’ So now that we have our basic definition out of the way, let’s roll up our sleeves and get to work. </p1>
                    </div>
                    <hr />
                </div>
                <div class="container profile">
                    <div class = "column">
                        <div class="col-md-4">
                            <h3 style={{ float:'left', width: '300px'}}>Rating: 5/5</h3>
                        </div>
                    </div>
                    <div> 
                        <h3 style={{ float:"left", width: '790px'}}> Insert Genres here </h3>
                    </div>
                    <div>
                        <Link className="btn btn-lg btn-secondary mr-2" to="/bookProfile">
                        Add book to cart
                        </Link>
                    </div>
                </div>
                <br /><br />
                <div class="container profile">
                    <div class = "column">
                        <div class="col-md-4"> 
                            <p style={{ float:'left', width: '300px', paddingRight: "30px"}}>Write about whatever extra info you want here bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla bla</p>
                        </div>
                    </div>
                    <div>
                    <h3 style={{ float:"left", width: '790px'}}> main book content here  </h3>
                    </div>
                </div>
            </>
        );
    }
}

    export default BookProfile;