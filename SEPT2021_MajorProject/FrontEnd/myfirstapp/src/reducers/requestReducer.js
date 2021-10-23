import { CREATE_REQ, GET_REQ} from "../actions/types";

const initialState = {
    requests: [],
    error: {},
  };
  
  export default function(state = initialState, action) {
    switch (action.type) {
      case CREATE_REQ:
        return {
          ...state,
          requests: action.payload
        };
  
      case GET_REQ:
        return {
          ...state,
          requests: action.payload
        };
  
      default:
        return state;
    }
  }