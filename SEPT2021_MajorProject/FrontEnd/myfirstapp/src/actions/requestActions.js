import axios from "axios";
import {CREATE_REQ, GET_REQS} from "./types";

export const createRequests = (AdminReq, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8082/api/requests/newRequest", AdminReq);
    history.push("/dashboard");
  } catch (err) {
    dispatch({
      type: CREATE_REQ,
      payload: err.response.data
    });
  }
};

export const getRequests = () => async dispatch => {
  const res = await axios.get("http://localhost:8082/api/requests/all");
  dispatch({
    type: GET_REQS,
    payload: res.data
  });
};