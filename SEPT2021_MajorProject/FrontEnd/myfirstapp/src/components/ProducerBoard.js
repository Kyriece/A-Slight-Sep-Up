import React, { Component } from 'react'
import Person from './Persons/Person'
import CreatePersonButton from './Persons/CreatePersonButton';
import Header from "./Layout/Header";

class ProducerBoard extends Component {
    render() {
        return (
            <>
                <Header />
                <div className="landing">
                    <div className="light-overlay landing-inner text-dark">
                        <div className="container">
                            <div className="row">
                                <div className="col-md-12 text-center">
                                    <h1 className="display-3 mb-4">
                                        Welcome Producer
                                    </h1>
                                    <hr />
                                    <p>Put Producer stuff here!</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </>
    
        )
    }
}
export default ProducerBoard;
