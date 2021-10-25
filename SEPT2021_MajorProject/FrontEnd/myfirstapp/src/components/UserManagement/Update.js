import React, {Component} from 'react';
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";
import store from "../../store";
import Checkbox from "rc-checkbox";
const OPTIONS = ["Publisher"];

//created base for publisher requests from registered users

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

  //methods for checkboxes, where publisher request is selected
  selectAllCheckboxes = isSelected => {
    Object.keys(this.state.checkboxes).forEach(checkbox => {
      this.setState(prevState => ({
        checkboxes: {
          ...prevState.checkboxes,
          [checkbox]: isSelected
        }
      }));
    });
  };

  selectAll = () => this.selectAllCheckboxes(true);

  deselectAll = () => this.selectAllCheckboxes(false);

  handleCheckboxChange = changeEvent => {
    const { name } = changeEvent.target;

    this.setState(prevState => ({
      checkboxes: {
        ...prevState.checkboxes,
        [name]: !prevState.checkboxes[name]
      }
    }));
  };

  handleFormSubmit = formSubmitEvent => {
    formSubmitEvent.preventDefault();

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

  //build the page 
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
            <div className="form-group mt-2">
              <button
                type="button"
                className="btn btn-outline-primary mr-2"
                onClick={this.selectAll}
              >
                Publisher Request
              </button>
              <button
                type="button"
                className="btn btn-outline-primary mr-2"
                onClick={this.deselectAll}
              >
                Cancel
              </button>
              <button type="submit" className="btn btn-primary">
                Save
              </button>
            </div>
          </form>
        </div>
        </div>
      </div>
      <Footer />
      </>
    );
  }
}
    
  export default Update;