import React, { Component } from 'react'
import Person from './Persons/Person'
import Header from "./Layout/Header";
import { Link } from 'react-router-dom';
import store from "../store";


class Dashboard extends Component {

    render() {
        const user = store.getState().security.user
        console.log(user);
        return (
            <>
                <Header />
                
                <Link className="btn btn-lg btn-primary mr-2" to="/UpdateUser">
                <h1>welcome {user.username}</h1>
                </Link>
            </>
    
        )
    }
}
export default Dashboard;
