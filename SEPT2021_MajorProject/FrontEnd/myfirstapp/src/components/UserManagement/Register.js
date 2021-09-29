import React, { Component } from "react";
import { createNewUser } from "../../actions/securityActions";
import * as PropTypes from 'prop-types'
import { connect } from "react-redux";
import classnames from "classnames";
import Header from "../Layout/Header";
import MyToast from "../MyToast"

class Register extends Component {
  constructor() {
    super();

    this.state = {
      username: "root@root.com",
      fullName: "rooty",
      password: "123qwe123qwe",
      confirmPassword: "123qwe123qwe",
      userStatus: "user",
      errors: {}
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onSubmit(e) {
    e.preventDefault();
    console.log(this.state)
    const newUser = {
      username: this.state.username,
      fullName: this.state.fullName,
      password: this.state.password,
      confirmPassword: this.state.confirmPassword,
      userStatus: this.state.userStatus
    };

    this.props.createNewUser(newUser, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    const { errors } = this.state;
    return (
      <>
        <Header />
        <div className="register">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h1 className="display-4 text-center">Sign Up</h1>
                <p className="lead text-center">Create your Account</p>
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.username
                      })}
                      placeholder="Full Name"
                      name="fullName"
                      value={this.state.fullName}
                      onChange={this.onChange}
                    />
                     {errors.username && (
                      <div className="invalid-feedback">{errors.username}</div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.username
                      })}
                      placeholder="Email Address (Username)"
                      name="username"
                      value={this.state.username}
                      onChange={this.onChange}
                    />
                     {errors.username && (
                      <div className="invalid-feedback">{errors.username}</div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="password"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.password
                      })}
                      placeholder="Password"
                      name="password"
                      value={this.state.password}
                      onChange={this.onChange}
                    />
                     {errors.password && (
                      <div className="invalid-feedback">{errors.password}</div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="password"
                      className="form-control form-control-lg"
                      placeholder="Confirm Password"
                      name="confirmPassword"
                      value={this.state.confirmPassword}
                      onChange={this.onChange}
                    />
                  </div>
                  <div className="form-group">
                    <select className="form-select" 
                    aria-label="Default select example"
                    value={this.state.userStatus}
                    name="userStatus"
                    onChange={this.onChange}>
                      <option disabled value = "">Select user type</option>
                      <option value="user">User</option>
                      <option value="admin">Admin</option>
                      <option value="publisher">Publisher</option>
                    </select>
                  </div>
                  <input type="submit" className="btn btn-info btn-block mt-4" />
                  <br/>
                  <center><p>Already have an account? Sign in <a href="/Login">here</a></p></center>
                </form>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  }
}

Register.propTypes = {
  createNewUser: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
  security: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  security: state.security,
  errors: state.errors
});
export default connect(
  mapStateToProps,
  { createNewUser }
)(Register);