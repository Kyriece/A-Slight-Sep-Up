import React, { Component } from "react";

import { connect } from "react-redux";
import {
  saveBook,
  fetchBook,
  updateBook,
  fetchLanguages,
  fetchGenres,
  getBookbyId
} from "../../actions/bookActions";

import { Card, Form, Button, Col, InputGroup, Image } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faSave,
  faPlusSquare,
  faUndo,
  faList,
  faEdit,
} from "@fortawesome/free-solid-svg-icons";
import MyToast from "../MyToast"

import Header from "../Layout/Header";

import Footer from "../Layout/Footer"

import store from "../../store";

class Book extends Component {
  constructor(props) {
    super(props);
    this.state = this.initialState;
    // this.state = {
    //   genres: [],
    //   languages: [],
    //   show: false,
    // };
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

  componentDidMount() {
    const bookId = +this.props.match.params.id;
    if (bookId) {
      this.props.fetchBook(bookId);
    }
    this.findAllLanguages();
  }

  findAllLanguages = () => {
    this.props.fetchLanguages();
      let bookLanguages = this.props.bookObject.languages;
      if (bookLanguages) {
        this.setState({
          languages: [{ value: "", display: "Select Language" }].concat(
            bookLanguages.map((language) => {
              return { value: language, display: language };
            })
          ),
        });
        this.findAllGenres();
      }
  };

  findAllGenres = () => {
    this.props.fetchGenres();
      let bookGenres = this.props.bookObject.genres;
      if (bookGenres) {
        this.setState({
          genres: [{ value: "", display: "Select Genre" }].concat(
            bookGenres.map((genre) => {
              return { value: genre, display: genre };
            })
          ),
        });
      }
  };

  findBookById = (bookId) => {
    this.props.fetchBook(bookId);
      let book = this.props.bookObject.book;
      if (book != null) {
        this.setState({
          id: book.id,
          title: book.title,
          author: book.author,
          coverPhotoURL: book.coverPhotoURL,
          isbnNumber: book.isbnNumber,
          price: book.price,
          language: book.language,
          genre: book.genre,
          blurb: book.blurb,
          authorDescription: book.authorDescription,
          rating: book.rating,
          tableOfContents: book.tableOfContents,
        });
      }
      console.log(book);
  };

  resetBook = () => {
    this.setState(() => this.initialState);
  };

  submitBook = (event) => {
    event.preventDefault();

    const book = {
      title: this.state.title,
      author: this.state.author,
      coverPhotoURL: this.state.coverPhotoURL,
      isbnNumber: this.state.isbnNumber,
      price: this.state.price,
      language: this.state.language,
      genre: this.state.genre,
      blurb: this.state.blurb,
      authorDescription: this.state.authorDescription,
      rating: this.state.rating,
      tableOfContents: this.state.tableOfContents,
    };

    this.props.saveBook(book);
      if (this.props.bookObject.book != null) {
        this.setState({ show: true, method: "post" });
      } else {
        this.setState({ show: false });
      }
      this.props.history.push("/list");
  };

  updateBook = (event) => {
    event.preventDefault();

    const book = {
      id: this.state.id,
      title: this.state.title,
      author: this.state.author,
      coverPhotoURL: this.state.coverPhotoURL,
      isbnNumber: this.state.isbnNumber,
      price: this.state.price,
      language: this.state.language,
      genre: this.state.genre,
      blurb: this.state.blurb,
      authorDescription: this.state.authorDescription,
      rating: this.state.rating,
      tableOfContents: this.state.tableOfContents,
    };
    this.props.updateBook(book)
      if (this.props.bookObject.book != null) {
        this.setState({ show: true, method: "put" });
      } else {
        this.setState({ show: false });
      }
    this.setState(this.initialState);
  };

  bookChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  bookList = () => {
    return this.props.history.push("/list");
  };

  render() {
    const { title, author, coverPhotoURL, isbnNumber, price, language, genre, blurb, authorDescription, rating, tableOfContents } =
      this.state;
    return (
      <>
      <Header/>
      <div>
        <div style={{ display: this.state.show ? "block" : "none" }}>
          <MyToast
            show={this.state.show}
            message={
              this.state.method === "put"
                ? "Book Updated Successfully."
                : "Book Saved Successfully."
            }
            type={"success"}
          />
        </div>
        <Card className={"border border-white bg-white text-black"}>
          <Card.Header>
            <FontAwesomeIcon icon={this.state.id ? faEdit : faPlusSquare} />{" "}
            {this.state.id ? "Update Book" : "Add New Book"}
          </Card.Header>
          <Form
            onReset={this.resetBook}
            onSubmit={this.state.id ? this.updateBook : this.submitBook}
            id="bookFormId"
          >
            <Card.Body>
              <Form.Row>
                <Form.Group as={Col} controlId="formGridTitle">
                  <Form.Label>Title</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    name="title"
                    value={title}
                    onChange={this.bookChange}
                    className={"bg-white text-black"}
                    placeholder="Enter Book Title"
                  />
                </Form.Group>
                <Form.Group as={Col} controlId="formGridAuthor">
                  <Form.Label>Author</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    name="author"
                    value={author}
                    onChange={this.bookChange}
                    className={"bg-white text-black"}
                    placeholder="Enter Book Author"
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col} controlId="formGridCoverPhotoURL">
                  <Form.Label>Cover Photo URL</Form.Label>
                  <InputGroup>
                    <Form.Control
                      required
                      autoComplete="off"
                      type="test"
                      name="coverPhotoURL"
                      value={coverPhotoURL}
                      onChange={this.bookChange}
                      className={"bg-white text-black"}
                      placeholder="Enter Book Cover Photo URL"
                    />
                    <InputGroup.Append>
                      {this.state.coverPhotoURL !== "" && (
                        <Image
                          src={this.state.coverPhotoURL}
                          // roundedright
                          width="40"
                          height="38"
                        />
                      )}
                    </InputGroup.Append>
                  </InputGroup>
                </Form.Group>
                <Form.Group as={Col} controlId="formGridISBNNumber">
                  <Form.Label>ISBN Number</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    name="isbnNumber"
                    value={isbnNumber}
                    onChange={this.bookChange}
                    className={"bg-white text-black"}
                    placeholder="Enter Book ISBN Number"
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col} controlId="formGridPrice">
                  <Form.Label>Price</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    name="price"
                    value={price}
                    onChange={this.bookChange}
                    className={"bg-white text-black"}
                    placeholder="Enter Book Price"
                  />
                </Form.Group>
                <Form.Group as={Col} controlId="formGridPrice">
                  <Form.Label>Rating</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    name="rating"
                    value={rating}
                    onChange={this.bookChange}
                    className={"bg-white text-black"}
                    placeholder="Enter Book Rating (Out of 5)"
                  />
                </Form.Group>
                <Form.Group as={Col} controlId="formGridLanguage">
                  <Form.Label>Language</Form.Label>
                  <Form.Control
                    // required
                    as="select"
                    custom
                    onChange={this.bookChange}
                    name="language"
                    value={language}
                    className={"bg-white text-blacke"}
                  >
                    <option disabled value = "">Select Language</option>
                      <option value="French">French</option>
                      <option value="English">English</option>
                      <option value="Spanish">Spanish</option>
                      <option value="Vietnamese">Vietnamese</option>
                      <option value="Russian">Russian</option>
                      <option value="Mandarin">Mandarin</option>
                      <option value="Arabic">Arabic</option>
                      <option value="Hindi">Hindi</option>
                  </Form.Control>
                </Form.Group>
                <Form.Group as={Col} controlId="formGridGenre">
                  <Form.Label>Genre</Form.Label>
                  <Form.Control
                    // required
                    as="select"
                    custom
                    onChange={this.bookChange}
                    name="genre"
                    value={genre}
                    className={"bg-white text-black"}
                  >
                   <option disabled value = "">Select Genre</option>
                      <option value="Textbook">Textbook</option>
                      <option value="Science">Science</option>
                      <option value="History">History</option>
                      <option value="Fantasy">Fantasy</option>
                      <option value="Biography">Biography</option>
                      <option value="Horror">Horror</option>
                      <option value="Romance">Romance</option>

                  </Form.Control>
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col} controlId="formGridTitle">
                  <Form.Label>Blurb</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    as="textarea"
                    rows={5}
                    name="blurb"
                    value={blurb}
                    onChange={this.bookChange}
                    maxlength="1400"
                    className={"bg-white text-black"}
                    placeholder="Enter Book Blurb"
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col} controlId="formGridTitle">
                  <Form.Label>Table of Contents</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    as="textarea"
                    rows={3}
                    name="tableOfContents"
                    value={tableOfContents}
                    onChange={this.bookChange}
                    maxlength="800"
                    className={"bg-white text-black"}
                    placeholder="Enter Book of Contents ................ 1"
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group as={Col} controlId="formGridAuthor">
                  <Form.Label>Author Description</Form.Label>
                  <Form.Control
                    required
                    autoComplete="off"
                    type="test"
                    name="authorDescription"
                    as="textarea"
                    rows={3}
                    maxlength="600"
                    value={authorDescription}
                    onChange={this.bookChange}
                    className={"bg-white text-black"}
                    placeholder="Enter Author Description"
                  />
                </Form.Group>
              </Form.Row>
            </Card.Body>
            <Card.Footer style={{ textAlign: "right" }}>
              <Button size="sm" variant="success" type="submit">
                <FontAwesomeIcon icon={faSave} />{" "}
                {this.state.id ? "Update" : "Save"}
              </Button>{" "}
              <Button size="sm" variant="info" type="reset">
                <FontAwesomeIcon icon={faUndo} /> Reset
              </Button>{" "}
              <Button
                size="sm"
                variant="info"
                type="button"
                onClick={() => this.bookList()}
              >
                <FontAwesomeIcon icon={faList} /> Book List
              </Button>
            </Card.Footer>
          </Form>
        </Card>
        <Footer />
      </div>
      </>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    bookObject: state.book,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    saveBook: (book) => dispatch(saveBook(book)),
    fetchBook: (bookId) => dispatch(fetchBook(bookId)),
    updateBook: (book) => dispatch(updateBook(book)),
    fetchLanguages: () => dispatch(fetchLanguages()),
    fetchGenres: () => dispatch(fetchGenres()),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Book);
