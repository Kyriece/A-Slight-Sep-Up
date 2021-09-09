import React, { Component } from 'react'
import Person from './Persons/Person'
import CreatePersonButton from './Persons/CreatePersonButton';
import Header from "./Layout/Header";

class AdminBoard extends Component {
    render() {
        return (
            <>
                <Header />
                <h1>This is Admin page</h1>
            </>
    
        )
    }
}
export default AdminBoard;
