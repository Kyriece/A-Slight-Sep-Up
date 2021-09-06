import React, { Component } from 'react'
import Person from './Persons/Person'
import CreatePersonButton from './Persons/CreatePersonButton';
import Header from "./Layout/Header";

class Dashboard extends Component {
    render() {
        return (
            <>
                <Header />
                <div className="Persons">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text-center">Category 1</h1>
                            <Person/>
                        </div>
                    </div>
                </div>
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12">
                                <h1 className="display-4 text-center">Category 2</h1>
                                <Person/>
                            </div>
                        </div>
                    </div>
                </div>
            </>
    
        )
    }
}
export default Dashboard;
