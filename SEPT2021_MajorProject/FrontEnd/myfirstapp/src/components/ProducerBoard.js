import React, { Component } from 'react'
import Person from './Persons/Person'
import CreatePersonButton from './Persons/CreatePersonButton';
import Header from "./Layout/Header";

class ProducerBoard extends Component {
    render() {
        return (
            <>
                <Header />
                <h1>This is Publisher's page</h1>
            </>
    
        )
    }
}
export default ProducerBoard;
