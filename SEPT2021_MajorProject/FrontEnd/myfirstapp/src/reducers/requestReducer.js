import { CREATE_REQ, GET_REQ} from "../actions/types";

const initialState = {
    arequests: "",
    error: "",
  };
  
  export default function(state = initialState, action) {
    switch (action.type) {
      case CREATE_REQ:
        return {
          ...state,
          arequests: action.payload
        };
  
      case GET_REQ:
        return {
          ...state,
          arequests: action.payload
        };
  
      default:
        return state;
    }
  }