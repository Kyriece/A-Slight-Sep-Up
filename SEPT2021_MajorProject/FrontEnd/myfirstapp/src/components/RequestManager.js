import React, {Component} from 'react';
import PropTypes from "prop-types";
import {connect} from 'react-redux';
import {getRequest} from "../actions/requestActions";
import Header from "./Layout/Header";
import Footer from "./Layout/Footer";


class RequestManager extends Component {

    componentDidMount() {
        this.props.getRequest();
    }

    getDataItems(data) {
        return data.map((dataItem)=>(
            <tr key={dataItem.id}>
                <td>{dataItem.id}</td>
                <td>{dataItem.user}</td>
                <td>{dataItem.title}</td>
                <td>{dataItem.requestComment}</td>
                <td>{dataItem.email}</td>
            </tr>
        ))
    }

    render() {
      console.log(this.props);

        // const {requests} = this.props.request;
        // console.log(requests);
        // let requestList = [];
        // for (let i =0; i < requests.length; i++) {
        //   requestList.push(requests[i]);
        // }
        // const requeststable = this.getDataItems(requestList)

        return (
            <>
            <Header/>
            <div>
                <h1 className="display-4 text-center"> User Manager Page </h1>
                <br/>
                <br/>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>id</td>
                            <td>user</td>
                            <td>title</td>
                            <td>request comment</td>
                            <td>email</td>
                        </tr>
                    </thead>
                    {/* <tbody>
                        {requeststable}
                    </tbody> */}
                </table>
            </div>
            <Footer />

            </>
        );
    }
}

RequestManager.propTypes ={
    request: PropTypes.object.isRequired,
    getRequest: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  request: state.request
});

export default connect(
    mapStateToProps,
    { getRequest }
)(RequestManager);
