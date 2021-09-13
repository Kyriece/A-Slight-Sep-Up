import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getUsers} from "./actions/userActions";


class UserManager extends Component {

    componentDidMount() {
        this.props.getUsers();
    }

    buildUserList(userList) {
        return userList.map((user)=>(
            <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.username}</td>
                <td>{user.fullName}</td>
                <td>{user.userstatus}</td>
                <td>{user.create_At}</td>
                <td>{user.accountNonLocked}</td>
                <td>{user.accountEnabled}</td>
                <td>{user.lockTime}</td>
            </tr>
        ))
    }

    getUserData(userObjects) {
        let userList = [];

        for (let i =0; i < userObjects.length; i++) {
            userList.push(userObjects[i]);
        }

        return userList;
    }

    render() {
        const {persons} = this.props.person
        const userList = this.getUserData({persons})
        const userTable = this.buildUserList(userList)

        return (
            <div>
                <h1> User Manager Page </h1>
                <br/>
                <br/>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>username</td>
                            <td>fullName</td>
                            <td>userstatus</td>
                            <td>create_At</td>
                            <td>accountNonLocked</td>
                            <td>accountEnabled</td>
                            <td>lockTime</td>
                        </tr>
                    </thead>
                    <tbody>
                        {userTable}
                    </tbody>
                </table>
            </div>
        );
    }
}

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