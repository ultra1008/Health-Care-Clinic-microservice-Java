import {connect} from "react-redux";
import RegisterPage from "./RegisterPage";
import {setStoreError} from "../../../actions";
import {sendRequestByGivenDetails} from "../../../actions/fetchRequest";
import {URLs} from "../../../URLs";

const getError = state => ( state.error );
const getUserInformation = state => ( state.userInformation );

const mapStateToProps = state => ({
    error: getError(state),
    userInformation: getUserInformation(state)
});

const mapDispatchToProps = dispatch => ({
    setStoreError: (error) => {dispatch(setStoreError(error))}
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(RegisterPage)

//CSS Stylesheet


//Content for fetch request
export const sendFetchRequestRegisterNewUser = (userRegisterInformation, {ifCatchSetErrorInStore}) => {
    const url = URLs.REGISTER_USER;

    const method = 'POST';

    const body = {
        "email": userRegisterInformation.email,
        "password": userRegisterInformation.password,
        "role": userRegisterInformation.role
    };

    const headers = {
        'Content-Type': 'application/json'
    };

    const setInStateFunction = null;

    let specialFunction;

    switch (userRegisterInformation.role) {
        case "doctor":
            specialFunction = (responseJSONData) => {
                const url = URLs.REGISTER_DOCTOR;

                const method = 'POST';

                const body = {
                    doctorUUID: responseJSONData.uuid,
                    firstName: userRegisterInformation.firstName,
                    lastName: userRegisterInformation.lastName,
                    photoUrl: userRegisterInformation.photoUrl,
                    licence: userRegisterInformation.licence
                };

                const headers = {
                    'Authorization': responseJSONData.token,
                    'Content-Type': 'application/json;charset=UTF-8',
                };

                const setInStateFunction = null;

                const specialFunction = null;

                sendRequestByGivenDetails(
                    url,
                    method,
                    body,
                    headers,
                    setInStateFunction,
                    specialFunction,
                    ifCatchSetErrorInStore
                );
            };
            break;
        case "patient":
            specialFunction = () => {console.log("Patient register")}
    }


    sendRequestByGivenDetails(
        url,
        method,
        body,
        headers,
        setInStateFunction,
        specialFunction,
        ifCatchSetErrorInStore
    );
};