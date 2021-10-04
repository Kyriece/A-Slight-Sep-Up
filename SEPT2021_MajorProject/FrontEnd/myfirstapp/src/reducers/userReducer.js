import {GET_USER, GET_USERS, SET_PUBREQUEST, UPDATE_USER} from "../actions/types";

const initialState = {
    users: [],
    user: {}
}

export default function(state = initialState, action) {

    switch(action.type) {

        case GET_USERS:
            return {
                ...state,
                users: action.payload
            };

        case GET_USER:
            return {
                ...state,
                user: action.payload
            };

        case UPDATE_USER:
            return {
                 ...state,
                user: action.payload
            };

        default:
            return state;
    }
}