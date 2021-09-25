import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getUser} from "../../actions/userActions";
import Header from "../Layout/Header";
import store from "../../store";

import Checkbox from "rc-checkbox";
const OPTIONS = ["YES", "NO"];

class Update extends Component{
  state = {
    checkboxes: OPTIONS.reduce(
      (options, option) => ({
        ...options,
        [option]: false
      }),
      {}
    )
  };

  handleCheckboxChange = changeEvent => {
    console.log("HANDLE CALED");

    const { name } = changeEvent.target;

    this.setState(prevState => ({
      checkboxes: {
        ...prevState.checkboxes,
        [name]: !prevState.checkboxes[name]
      }
    }));
  };

  handleFormSubmit = formSubmitEvent => {
    console.log("SUBMIT CALED");
    formSubmitEvent.preventDefault();
    console.log("SUBMIT 2 CALED");
    
    Object.keys(this.state.checkboxes)
      .filter(checkbox => this.state.checkboxes[checkbox])
        .forEach(checkbox => {
          console.log(checkbox, "is selected.");
        });
  };

  createCheckbox = option => (
    <Checkbox
      label={option}
      isSelected={this.state.checkboxes[option]}
      onCheckboxChange={this.handleCheckboxChange}
      key={option}
    />
  );

  createCheckboxes = () => OPTIONS.map(this.createCheckbox);

  render() {
      const user = store.getState().security.user
      console.log(user);
      return (
          <>
          <Header/>
          <div>
              <h1 className="display-4 text-center"> {user.id} </h1>
              <h1 className="display-4 text-center"> {user.username} </h1>
              <h1 className="display-4 text-center"> {user.fullName} </h1>
              <h1 className="display-4 text-center"> {user.publisherRequest} </h1>
              <h1 className="display-4 text-center"> {user.userStatus} </h1>
          </div>
          <div className="container">
        <div className="row mt-5">
          <div className="col-sm-12">
            <form onSubmit={this.handleFormSubmit}>
              {this.createCheckboxes()}
              <div className="form-group mt-2">
                <button type="submit" className="btn btn-primary">
                  Save
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
      );
    }
  }
    
  export default Update;