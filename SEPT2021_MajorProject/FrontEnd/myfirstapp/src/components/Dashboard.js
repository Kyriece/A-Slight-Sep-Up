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
                <div className="landing">
                    <div className="light-overlay landing-inner text-dark">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-12 text-center">
                                    <h1 className="display-3 mb-4">
                                        Dashboard
                                    </h1>
                                    <hr />
                                    <p>Display Books here!</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </>
    
        )
    }
}
export default Dashboard;
