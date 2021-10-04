import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getPubUsers} from "../actions/userActions";
import Header from "./Layout/Header";


class UserManager2 extends Component {

    componentDidMount() {
        this.props.getPubUsers();
    }

    getDataItems(data) {
        return data.map((dataItem)=>(
            <tr key={dataItem.id}>
                <td>{dataItem.id}</td>
                <td>{dataItem.username}</td>
                <td>{dataItem.fullName}</td>
                <td>{dataItem.userStatus}</td>
            </tr>
        ))
    }

    render() {

        const {pubusers} = this.props.pubusers;
        console.log(pubusers);
        let userList = [];
        for (let i =0; i < pubusers.length; i++) {
            userList.push(pubusers[i]);
        }
        const userstable = this.getDataItems(userList)

        return (
            <>
            <Header/>
            <div>
                <h1 className="display-4 text-center"> User Manager 2 Page </h1>
                <br/>
                <br/>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>username</td>
                            <td>fullName</td>
                            <td>userstatus</td>
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

UserManager2.propTypes ={
    pubusers: PropTypes.object.isRequired,
    getPubUsers: PropTypes  .func.isRequired
};

const mapStateToProps = state => ({
    pubusers: state.pubusers
});

export default connect(
    mapStateToProps,
    { getPubUsers }
)(UserManager2);
