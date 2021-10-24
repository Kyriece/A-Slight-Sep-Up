import * as BT from "./types";
import axios from "axios";

export const saveBook = (book) => {
  return (dispatch) => {
    dispatch({
      type: BT.SAVE_BOOK_REQUEST,
    });
    axios
      .post("http://localhost:8081/api/books", book)
      .then((response) => {
        dispatch(bookSuccess(response.data));
        alert("save succesful")
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

export const fetchBook = (bookId) => {
  return (dispatch) => {
    axios
      .get("http://localhost:8081/api/books/" + bookId)
      .then((response) => {
        dispatch(bookSuccess(response.data));
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

export const findBookById = async (id) => {
  return await axios.get("http://localhost:8081/api/books/" + id)
    .then(async (res) => {
      return await res.data;
    })
    .catch((error) => {
      console.log(error);
    });
};

export const updateBook = (book) => {
  console.log(book);
  return (dispatch) => {
    dispatch({
      type: BT.UPDATE_BOOK_REQUEST,
    });
    axios
      .put("http://localhost:8081/api/books", book)
      .then((response) => {
        dispatch(bookSuccess(response.data));
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

export const deleteBook = (bookId) => {
  return (dispatch) => {
    dispatch({
      type: BT.DELETE_BOOK_REQUEST,
    });
    axios
      .delete("http://localhost:8081/api/books/" + bookId)
      .then((response) => {
        dispatch(bookSuccess(response.data));
      })
      .catch((error) => {
        dispatch(bookFailure(error));
      });
  };
};

const bookSuccess = (book) => {
  return {
    type: BT.BOOK_SUCCESS,
    payload: book,
  };
};

const bookFailure = (error) => {
  return {
    type: BT.BOOK_FAILURE,
    payload: error,
  };
};


export const getBookbyId = (id) => async dispatch => {
  try {
    const res = await axios.get("http://localhost:8081/api/books/" + id);
    dispatch({
      type: BT.GET_BOOK,
      payload: res.data
    });
  } catch (error) {
    console.log(error.response);
  }
};