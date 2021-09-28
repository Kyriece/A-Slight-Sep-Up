import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getUsers} from "../actions/userActions";
import Header from "./Layout/Header";


class UserManager extends Component {

    componentDidMount() {
        this.props.getUsers();
    }

    getDataItems(data) {
        return data.map((dataItem)=>(
            <tr key={dataItem.id}>
                <td>{dataItem.id}</td>
                <td>{dataItem.username}</td>
                <td>{dataItem.fullName}</td>
                <td>{dataItem.userStatus}</td>
                <td>{dataItem.publisherrequest ? <div>TRUE</div> : <div>FALSE</div>}</td>
            </tr>
        ))
    }

    render() {

        const {users} = this.props.user;
        console.log(users);
        let userList = [];
        for (let i =0; i < users.length; i++) {
            userList.push(users[i]);
        }
        const userstable = this.getDataItems(userList)

        return (
            <>
            <Header/>
            <div>
                <h1 className="display-4 text-center"> User Manager Page </h1>
                <br/>
                <br/>
                <table className = "table table-striped">
                    <thead>
                        <tr>
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
            </>
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
