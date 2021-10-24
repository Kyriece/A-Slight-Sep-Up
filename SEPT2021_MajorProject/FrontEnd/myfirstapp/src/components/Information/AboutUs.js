import React, { Component } from 'react'
import Header from "../Layout/Header";
import Footer from "../Layout/Footer";

// simple webpage for information section
class AboutUs extends Component {
  render() {
    return (
        <>
          <Header />
          {/* the header follows some general bootstrap styling */}
            <div className="landing">
                <div className="light-overlay landing-inner text-dark">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12 text-center">
                                <h1 className="display-8 mb-4"> About Us </h1>
                                <hr />
                                {/* hard coded information statement */}
                                <p>A small team of developers with a love for books and an exciting dream!</p>
                                <p>Bookeroo wouldn't be possible if it wasn't backed by our lovely membership base, thank you for all your support!</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          <Footer />
        </>
    )
  }
}
export default AboutUs;
