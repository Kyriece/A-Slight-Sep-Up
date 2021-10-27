import * as BT from "../actions/types";

const initialState = {
  book: [],
  error: {},
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case BT.SAVE_BOOK_REQUEST:
    case BT.FETCH_BOOK_REQUEST:
    case BT.UPDATE_BOOK_REQUEST:
    case BT.DELETE_BOOK_REQUEST:
    case BT.GET_BOOK:
      return {
        ...state,
      };
    case BT.BOOK_SUCCESS:
      return {
        book: action.payload,
        error: "",
      };
    case BT.BOOK_FAILURE:
      return {
        book: "",
        error: action.payload,
      };
      case BT.GET_BOOK:
        return {
          book: "",
          error: action.payload,
        };
    default:
      return state;
  }
};

export default reducer;
