// import React, {Component} from 'react';
// import PropTypes from "prop-types";
// import {connect} from 'react-redux';
// import classnames from "classnames";
// import {setPubrequest} from "../actions/userActions";
// import Header from "./Layout/Header";


// class UserToPublisher extends Component {
//     constructor() {
//         super();
//         this.state = {
//           errors: {}
//         };
//         this.onSubmit = this.onSubmit.bind(this);
//       }


//   render() {
//     const { errors } = this.state;
//     return (
//       <>
//         <Header />
//         <div className="publisher request form">
//           <div className="container">
//             <div className="row">
//               <div className="col-md-8 m-auto">
//                 <h1 className="display-4 text-center">Log In</h1>
//                 <form onSubmit={this.onSubmit}>
//                   <div className="form-group">
//                     <input
//                       type="publisherName"
//                       placeholder="name of publishing house"
//                       name="placeholder"
//                     />
//                   </div>
//                   <div className="form-group">
//                     <input
//                       type="reasoning"
//                       placeholder="why do you want to be a publisher"
//                       name="placeholder2"
//                     />
//                   </div>
//                   <input type="submit" className="btn btn-info btn-block mt-4" />
//                 </form>
//               </div>
//             </div>
//           </div>
//         </div>
//       </>
//     );
//   }
// }


// UserToPublisher.propTypes ={
//     user: PropTypes.object.isRequired,
//     setPubrequest: PropTypes.func.isRequired
// };

// const mapStateToProps = state => ({
//     user: state.user
// });

// export default connect(
//     mapStateToProps,
//     { setPubrequest }
// )(UserToPublisher);