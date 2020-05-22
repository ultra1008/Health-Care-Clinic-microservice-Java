import React from "react";
import {FormForInputUserInformation} from "../../AdditionalComponents/FormForInputUserInfo/FormForInputUserInformation";
import {Container} from "@material-ui/core";
import AlertMessage from "../../AdditionalComponents/Alert/AlertMessage";

export const LoginPage = (props) => {

  const {
    userDetails,
    dispatchUserState,
    sendFetchForLoginUser
  } = props;

  const styleForMainContainer = {
    backgroundColor: "white",
    margin: "0px",
    padding: "0px"
  };

  //Main HTML return
  return (
    <Container
      style={styleForMainContainer}
    >
      <AlertMessage
        show={userDetails.isError}
        onClose={() => {dispatchUserState({type: "CLOSE_ERROR_MASSAGE"})}}
        message="Wrong Login Details"
        type="error"
      />
      <FormForInputUserInformation
        {...props}
        fetchRequest        ={(loginDetails) => {sendFetchForLoginUser(loginDetails)}}
        submitButtonTitle   ="Log In"
        showEmailForm       ={true}
        showPasswordForm    ={true}
        showRoleForm        ={false}
        showFirstNameForm   ={false}
        showLastNameForm    ={false}
        showLicenceForm     ={false}
        showPhotoURLForm    ={false}
      />
    </Container>
  );
};

export default LoginPage
