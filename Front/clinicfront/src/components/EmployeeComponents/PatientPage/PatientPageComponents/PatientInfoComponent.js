import {ContainerForUserInformation} from "../../../AdditionalComponents/ContainerForUserInformation/ContainerForUserInformation";
import React from "react";

export const PatientInfoComponent = (props) => {
  return(
    <ContainerForUserInformation
      {...props}
      userInformation={props.patientInformation}
      titleRole={"PATIENT"}
      firstName={true}
      lastName={true}
      pesel={true}
    />
  )
};

export default PatientInfoComponent