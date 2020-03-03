import {sendRequestByGivenDetails} from "../actions";
import {URLs} from "../URL's";

//CSS stylesheet
export const styleForFormLabel = {
    color:'white'
};

export const styleForForm = {
    border: '2px solid white',
    borderRadius: '5px',
    padding: '8px'
};

export const styleForMainDiv = {
    margin: '50px auto auto 50px',
    width: '60%',
};

//Content for fetch request
export const sendFetchRequestRegisterNewDoctor = (userRegisterInformation) => {
    const body = {
        "email": userRegisterInformation.email,
        "password": userRegisterInformation.password,
        "role": userRegisterInformation.role
    };

    const headers = {
        'Content-Type': 'application/json'
    };

    const setInStateFunction = null;

    const specialFunction = (responseJSONData) => {
        const body = {
            doctoruuid: responseJSONData.uuid,
            firstName: userRegisterInformation.firstName,
            lastName: userRegisterInformation.lastName,
            photoUrl: userRegisterInformation.photoURL,
            licence: userRegisterInformation.licence
        };

        const headers = {
            'Authorization': responseJSONData.token,
            'Content-Type': 'application/json;charset=UTF-8',
        };

        const setInStateFunction = null;

        const specialFunction = null;

        sendRequestByGivenDetails(
            URLs.REGISTER_DOCTOR,
            'POST',
            body,
            headers,
            setInStateFunction,
            specialFunction
        );
    };

    sendRequestByGivenDetails(
        URLs.REGISTER_USER,
        'POST',
        body,
        headers,
        setInStateFunction,
        specialFunction
    );
};