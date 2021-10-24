import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getUsers} from "../actions/userActions";
import Header from "./Layout/Header";
import Footer from "./Layout/Footer";


class UserManager extends Component {

  componentDidMount() {
      this.props.getUsers();
  }

  // define data items
  getDataItems(data) {
    return data.map((dataItem)=>(
      <tr key={dataItem.id}>
        <td>{dataItem.id}</td>
        <td>{dataItem.ti}</td>
        <td>{dataItem.fullName}</td>
        <td>{dataItem.userStatus}</td>
        <td>{dataItem.publisherrequest ? <div>TRUE</div> : <div>FALSE</div>}</td>
      </tr>
    ))
  }

render() {
  const {users} = this.props.user;
  let userList = [];
  // react loop to iterate all the users into the userList array
  for (let value of users) {
    userList.push(value);
  }
  const userstable = this.getDataItems(userList)

  return (
    <>
    {/* header variable declared on every page, as well as the footer */}
      <Header/>
      <div>
        <h1 className="display-4 text-center"> User Manager Page </h1>
        <br/>
        <br/>
        {/* bootstrap table styling and formatting */}
        <table className = "table table-striped">
          <thead>
            <tr>
              {/* table values defined */}
              <td>id</td>
              <td>username</td>
              <td>fullName</td>
              <td>userstatus</td>
              <td>publisherrequest</td>
            </tr>
          </thead>
            <tbody>
              {userstable}
            </tbody>
          </table>
        </div>
        <Footer />
      </>
    );
  }
}

// render and return the compiled application
UserManager.propTypes ={
    user: PropTypes.object.isRequired,
    getUsers: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
    user: state.user
});

export default connect(
    mapStateToProps,
    { getUsers }
)(UserManager);
