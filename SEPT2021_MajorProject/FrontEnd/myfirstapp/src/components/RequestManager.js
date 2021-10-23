import React, { useEffect, useState } from 'react';
import { connect } from 'react-redux';
import { getRequest } from "../actions/requestActions";
import Header from "./Layout/Header";
import Footer from "./Layout/Footer";


const RequestManager = ({ getRequest }) => {

    const [request, setRequest] = useState();

    useEffect(() => {
        async function fetchData () {
          const res = await getRequest()
          setRequest(res)
        }
        fetchData()
    }, [])

    return <>
        <Header />
        <div>
            <h1 className="display-4 text-center"> User Manager Page </h1>
            <br />
            <br />
            <table className="table table-striped">
                <thead>
                    <tr>
                        <td>id</td>
                        <td>user</td>
                        <td>title</td>
                        <td>request comment</td>
                        <td>email</td>
                    </tr>
                </thead>
                <tbody>
                    {request && request.map((dataItem) => (
                        <tr key={dataItem.id}>
                            <td>{dataItem.id}</td>
                            <td>{dataItem.user}</td>
                            <td>{dataItem.title}</td>
                            <td>{dataItem.requestComment}</td>
                            <td>{dataItem.email}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
        <Footer />
    </>
}

const mapStateToProps = state => ({
    request: state.request
});

export default connect(
    mapStateToProps,
    { getRequest }
)(RequestManager);
