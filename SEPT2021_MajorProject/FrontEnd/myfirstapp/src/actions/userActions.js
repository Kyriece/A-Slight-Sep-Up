import axios from "axios";
import {GET_USERS, GET_USER, GET_ERRORS, SET_PUBREQUEST, UPDATE_USER} from "./types";

export async function getUser(id) {
    try {
        const res = await axios.get(`/api/user/${id}`);
        return res.data;
    } catch (error) {
        console.log("error in user fetch");
    }
};

export const getUsers = () => async dispatch => {
    const res = await axios.get("http://localhost:8080/api/users/all");
    dispatch({
        type: GET_USERS,
        payload: res.data
    });
};

export const UpdateUser = (User, Userid) => async dispatch => {
    const res = await axios.put("http://localhost:8080/api/users/updaterequest" + "/" + Userid, User);
    dispatch({
        type: UPDATE_USER,
        payload: res.data
    });
};


