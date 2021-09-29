import React, { Component } from 'react'
import Person from './Persons/Person'
import CreatePersonButton from './Persons/CreatePersonButton';
import Header from "./Layout/Header";
import { Link } from 'react-router-dom';
import { getUser } from "../actions/userActions";
import store from "../store";


class AdminBoard extends Component {
    render() {
        const user = store.getState().security.user 
        return (
            <>
                <Header />
                <div className="landing">
                    <div className="light-overlay landing-inner text-dark">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-12 text-center">
                                    <h1 className="display-3 mb-4">
                                        Welcome admin {user.username}
                                    </h1>
                                    <hr />
                                    <Link className="btn btn-lg btn-primary mr-2" to="/userManager">
                                        User Management
                                    </Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </>

        )
    }
}
export default AdminBoard;
