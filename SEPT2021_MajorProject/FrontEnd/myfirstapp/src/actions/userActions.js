import axios from "axios";
import {GET_USERS, GET_USER, GET_ERRORS, SET_PUBREQUEST, UPDATE_USER, GET_PUBUSERS} from "./types";
import setJWTToken from "../securityUtils/setJWTToken";
import jwt_decode from "jwt-decode";

export async function getUser(id) {
        const res = await axios.get(`http://localhost:8080/api/user/${id}`);
    
};

export const getUsers = () => async dispatch => {
    const res = await axios.get("http://localhost:8080/api/users/all");
    dispatch({
        type: GET_USERS,
        payload: res.data
    });
};

export const getPubUsers = () => async dispatch => {
    const res = await axios.get("http://localhost:8080/api/users/usertopublisher");
    dispatch({
        type: GET_PUBUSERS,
        payload: res.data
    });
};

export const UpdateUser = (id) => async dispatch =>{
    try {
    console.log("function called");
    const res = await axios.put("http://localhost:8080/api/users/updaterequest", {id});
    console.log("succesful", res);
    dispatch({
        type: UPDATE_USER,
        payload: res.data
    });
    } catch (error){
        console.log(error.response);
    }

};


