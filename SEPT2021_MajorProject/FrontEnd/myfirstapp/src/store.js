import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";

import rootReducer from "./reducers";

const initalState = {}; /* Bucket of legos. */

/* Initialise bucket */
let store; 
store = createStore(
  rootReducer,
  initalState,
  compose(applyMiddleware(...[thunk]),)
);

export default store;
