import axios from "axios";
import {CREATE_REQ, GET_REQ} from "./types";

export const createRequests = (AdminReq, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8082/api/requests/newRequest", AdminReq);
    alert('You have submitted the form.');
    dispatch({
      type: CREATE_REQ,
      payload: {}
    });
  } catch (err) {
    dispatch({
      type: CREATE_REQ,
      payload: err.response.data
    });
  }
};

export const getRequest = () => async dispatch => {
  const res = await axios.get("http://localhost:8082/api/requests/all");
  dispatch({
    type: GET_REQ,
    payload: res.data
  });
};