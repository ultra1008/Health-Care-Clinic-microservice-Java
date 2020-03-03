import {connect} from "react-redux";
import DoctorPage from "../../components/EmployeeComponents/DoctorPage";
import {setStoreDoctorInformation} from "../../actions";
import {sendRequestByGivenDetails} from "../../actions/fetchRequest";
import {URLs} from "../../URLs";

const getUserDetails = state => ( state.info.userDetails );
const getUserInformation = state => ( state.info.userInformation );

const mapStateToProps = state => ({
    userDetails: getUserDetails(state),
    userInformation: getUserInformation(state)
});

const mapDispatchToProps = dispatch => ({
    setStoreUserInformation: (userInformation) => {dispatch(setStoreDoctorInformation(userInformation))}
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(DoctorPage)

//Content for fetch request
export const sendFetchRequestSetUserInformation = (uuid, {setUserInformation}) => {
    const body = null;

    const headers = {'Authorization': localStorage.token};

    const setInStateFunction = (responseData) => setUserInformation(responseData);

    const specialFunction = null;

    sendRequestByGivenDetails(
        URLs.GET_USER_INFORMATION + uuid,
        'GET',
        body,
        headers,
        setInStateFunction,
        specialFunction,
    )
};

export const sendFetchRequestChangeUserInformation = () => {
    // const body = null;
    //
    // const headers = {};
    //
    // const setInStateFunction = null;
    //
    // const specialFunction = null;
    //
    // sendRequestByGivenDetails(
    //     URLs.GET_USER_INFORMATION,
    //     'GET',
    //     body,
    //     headers,
    //     setInStateFunction,
    //     specialFunction,
    // )
};

export const sendFetchRequestDeleteUser = () => {
    // const body = null;
    //
    // const headers = {};
    //
    // const setInStateFunction = null;
    //
    // const specialFunction = null;
    //
    // sendRequestByGivenDetails(
    //     URLs.GET_USER_INFORMATION,
    //     'GET',
    //     body,
    //     headers,
    //     setInStateFunction,
    //     specialFunction,
    // )
};