import React, { Component } from 'react'
import Person from './Persons/Person'
import CreatePersonButton from './Persons/CreatePersonButton';
import Header from "./Layout/Header";
import { Link } from 'react-router-dom';

class AdminBoard extends Component {
    render() {
        return (
            <>
                <Header />
                <Link className="btn btn-lg btn-primary mr-2" to="/UserManager">
                <h1>This is Admin page</h1>
                </Link>
                <Link className="btn btn-lg btn-primary mr-2" to="/UserManager2">
                <h1>Users who want to be publishers</h1>
                </Link>
            </>
    
        )
    }
}
export default AdminBoard;
