import React, { useEffect, useState } from "react";

import { connect } from "react-redux";
import { useParams, useHistory } from "react-router-dom";
import { Card, Form, Button, Col, InputGroup, Image } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

import Header from "../Layout/Header";

import { findBookById, updateBook } from "../../actions/bookActions";

import {
  faSave,
  faUndo,
  faList,
} from "@fortawesome/free-solid-svg-icons";

const Book = (props) => {
  const { id } = useParams();

  const history = useHistory();

  const [book, setBook] = useState();

  useEffect(() => {    
    async function fetchBook() {
      const newBook = await findBookById(id);
      setBook(newBook);
    };
    fetchBook();
  }, []);

  if (!book) return null;

  const {
    title,
    author,
    coverPhotoURL,
    isbnNumber,
    price,
    language,
    genre,
    blurb,
    authorDescription,
    rating,
    tableOfContents
  } = book;

  function handleSubmit(e) {
    e.preventDefault();
    props.updateBook(book);
    history.push('/list');
  };

  return (
    <>
      <Header />
      <Form onSubmit={handleSubmit}>
        <Card.Body>
          <Form.Row>
            <Form.Group as={Col}>
              <Form.Label>Title</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                name="title"
                value={title}
                onChange={(e) => setBook({...book, title: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Book Title"
              />
            </Form.Group>
            <Form.Group as={Col}>
              <Form.Label>Author</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                name="author"
                value={author}
                onChange={(e) => setBook({...book, author: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Book Author"
              />
            </Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col} >
              <Form.Label>Cover Photo URL</Form.Label>
              <InputGroup>
                <Form.Control

                  autoComplete="off"
                  type="text"
                  name="coverPhotoURL"
                  value={coverPhotoURL}
                  onChange={(e) => setBook({...book, coverPhotoURL: e.target.value})}
                  className={"bg-white text-black"}
                  placeholder="Enter Book Cover Photo URL"
                />
                <InputGroup.Append>
                  {coverPhotoURL !== "" && (
                    <Image
                      src={coverPhotoURL}
                      width="40"
                      height="38"
                    />
                  )}
                </InputGroup.Append>
              </InputGroup>
            </Form.Group>
            <Form.Group as={Col} >
              <Form.Label>ISBN Number</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                name="isbnNumber"
                value={isbnNumber}
                onChange={(e) => setBook({...book, isbnNumber: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Book ISBN Number"
              />
            </Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col} >
              <Form.Label>Price</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                name="price"
                value={price}
                onChange={(e) => setBook({...book, price: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Book Price"
              />
            </Form.Group>
            <Form.Group as={Col} >
              <Form.Label>Rating</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                name="rating"
                value={rating}
                onChange={(e) => setBook({...book, rating: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Book Rating (Out of 5)"
              />
            </Form.Group>
            <Form.Group as={Col} >
              <Form.Label>Language</Form.Label>
              <Form.Control

                as="select"
                custom
                onChange={(e) => setBook({...book, language: e.target.value})}
                name="language"
                value={language}
                className={"bg-white text-blacke"}
              >
                <option disabled value="">Select Language</option>
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
            <Form.Group as={Col} >
              <Form.Label>Genre</Form.Label>
              <Form.Control

                as="select"
                custom
                onChange={(e) => setBook({...book, genre: e.target.value})}
                name="genre"
                value={genre}
                className={"bg-white text-black"}
              >
                <option disabled value="">Select Genre</option>
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
            <Form.Group as={Col} >
              <Form.Label>Blurb</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                as="textarea"
                rows={5}
                name="blurb"
                value={blurb}
                onChange={(e) => setBook({...book, blurb: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Book Blurb"
              />
            </Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col} >
              <Form.Label>Table of Contents</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                as="textarea"
                rows={3}
                name="tableOfContents"
                value={tableOfContents}
                onChange={(e) => setBook({...book, tableOfContents: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Book of Contents ................ 1"
              />
            </Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col} >
              <Form.Label>Author Description</Form.Label>
              <Form.Control
                autoComplete="off"
                type="text"
                name="authorDescription"
                as="textarea"
                rows={3}
                value={authorDescription}
                onChange={(e) => setBook({...book, authorDescription: e.target.value})}
                className={"bg-white text-black"}
                placeholder="Enter Author Description"
              />
            </Form.Group>
          </Form.Row>
        </Card.Body>
        <Card.Footer style={{ textAlign: "right" }}>
          <Button size="sm" variant="success" type="submit">
            <FontAwesomeIcon icon={faSave} />
            Save
          </Button>
          <Button size="sm" variant="info" type="reset">
            <FontAwesomeIcon icon={faUndo} /> 
            Reset
          </Button>
          <Button
            size="sm"
            variant="info"
            type="button"
            onClick={() => history.push("/booklist")}
          >
            <FontAwesomeIcon icon={faList} /> Book List
          </Button>
        </Card.Footer>
      </Form>
    </>
  )
}

const mapStateToProps = (state) => {
  return {
    bookObject: state.book,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    updateBook: (book) => dispatch(updateBook(book)),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Book);
