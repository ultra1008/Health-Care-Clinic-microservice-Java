import {ContainerForUserInformation} from "../../../AdditionalComponents/ContainerForUserInformation/ContainerForUserInformation";
import React from "react";

export const DoctorInfoComponent = (props) => {
    return(
        <ContainerForUserInformation
            {...props}
            userInformation={props.doctorInformation}
            titleRole={"DOCTOR"}
            firstName={true}
            lastName={true}
            licence={true}
            specializations={true}
        />
    )
};

export default DoctorInfoComponent