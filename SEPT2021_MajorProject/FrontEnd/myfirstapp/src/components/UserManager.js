import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getUsers} from "../actions/userActions";


class UserManager extends Component {

    componentDidMount() {
        this.props.getUsers();
    }

    buildUserList(userList) {
        let userObject = userList.map((user)=>(
            <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.fullName}</td>
                <td>{user.userStatus}</td>
            </tr>
        ));
        return userObject;
    }

    getUserData(userObjects) {
        let userList = [];

        for (let i =0; i < userObjects.length; i++) {
            userList.push(userObjects[i]);
        }

        return userList;
    }

    getDataItems(data) {
        return data.map((dataItem)=>(
            <tr key={dataItem.id}>
                <td>{dataItem.id}</td>
                <td>{dataItem.fullName}</td>
                <td>{dataItem.userStatus}</td>
                <td>{dataItem.username}</td>

            </tr>
        ))
    }

    render() {
        // const {users} = this.props.user
        // const userList = this.getUserData({users})
        // const {userTable} = this.buildUserList(userList)
        const {users} = this.props.user;
        let userList = [];
        for (let i =0; i < users.length; i++) {
            userList.push(users[i]);
        }
        const lotsofpeople = this.getDataItems(userList)

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
                        {lotsofpeople}
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