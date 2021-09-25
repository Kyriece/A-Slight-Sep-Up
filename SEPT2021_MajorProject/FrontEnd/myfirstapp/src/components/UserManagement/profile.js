import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getUsers} from "../../actions/userActions";
import Header from "../Layout/Header";

class profile extends component{
    componentDidMount() {
        this.props.getUser();
    }

    getDataItems(data) {
        return data.map((dataItem)=>(
            <tr key={dataItem.id}>
                <td>{dataItem.id}</td>
                <td>{dataItem.username}</td>
                <td>{dataItem.fullName}</td>
                <td>{dataItem.userStatus}</td>
                <td>{dataItem.publisherRequest}</td>
            </tr>
        ))
    }

}