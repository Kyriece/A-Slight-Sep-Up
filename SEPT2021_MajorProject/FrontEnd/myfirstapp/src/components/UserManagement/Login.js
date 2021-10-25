import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classnames from "classnames";
import { login } from "../../actions/securityActions";
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";
import store from "../../store";

class Login extends Component {
  constructor() {
    super();
    this.state = {
      username: "",
      password: "",
      errors: {}
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  //on success, take the logged in user to dashboard
  componentDidMount() {
    if (this.props.security.validToken) {
      this.props.history.push("/dashboard");
    }
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.security.validToken) {
      const user = store.getState().security.user
      if(user.userStatus === "admin"){
        this.props.history.push("/adminboard");
      }
      else if(user.userStatus === "publisher"){
        this.props.history.push("/producerboard");
      }
      else{
        this.props.history.push("/list");
      }
    }

    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
  }

  //submit actions , push the login request
  onSubmit(e) {
    e.preventDefault();
    const LoginRequest = {
      username: this.state.username,
      password: this.state.password
    };
    this.props.login(LoginRequest, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  //constructing and defining the app, and error handling 
  render() {
    const { errors } = this.state;
    return (
      <>
        <Header />
        <div className="login">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h1 className="display-4 text-center">Log In</h1>
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg", {
                        "is-invalid": errors.username
                      })}
                      placeholder="Email Address"
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
                  <input type="submit" className="btn btn-info btn-block mt-4" />
                </form>
              </div>
            </div>
          </div>
        </div>
        <Footer />
      </>
    );
  }
}

Login.propTypes = {
  login: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
  security: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  security: state.security,
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { login }
)(Login);
