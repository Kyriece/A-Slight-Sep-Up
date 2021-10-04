import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import Header from "../Layout/Header";
import { Link} from "react-router-dom";
import store from '../../store';
import axios from 'axios';


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
            genre:result.data.genre
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
                <div class="container profile">
                    <div class="column" >
                        <div class="col-md-4">
                            <div style={{ paddingRight: '50px', float: 'left', width: '300px', height: '400px' }}>
                                <img src={this.state.coverPhotoURL} alt="" style={{height: '100%'}} />
                            </div>
                        </div>
                    </div>
                    <div style={{ paddingLeft: '20px', float:'left', width:'790px', height:'400px' }}>
                        <br></br>
                        <h1 className="display-4 text-center"> {this.state.title}</h1>
                        <div></div>
                        <p1 className="display-8 text-center"> A blurb is a short description of a book that is written for promotional purposes. Traditionally, it would be found on the inside back cover of a hardback. As paperback publishing developed, readers began seeing the blurb appearing on the back cover. Generally, 150-200 words are more than enough for a full blurb.
                            In the modern publishing landscape, where more books are being purchased online than in bricks and mortar stores, you are more likely to encounter blurbs on the product page of Amazon or any other digital retailer. Sometimes, you will hear them referred to as ‘book descriptions.’ So now that we have our basic definition out of the way, let’s roll up our sleeves and get to work. </p1>
                    </div>
                </div>
                <div class="container profile">
                    <div class = "column">
                        <div class="col-md-4" style={{ float:'left', width: '300px'}}>
                            <h3 >Rating: 5/5</h3>
                            <Link className="btn btn-lg btn-secondary mr-2" to="/bookProfile">
                            Add to cart: ${this.state.price}
                            </Link>
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
                            <p >Write about the author here bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla blabla bla bla</p>
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

  


export default BookProfile