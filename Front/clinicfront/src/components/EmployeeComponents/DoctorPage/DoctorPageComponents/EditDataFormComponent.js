import {Grid, Typography} from "@material-ui/core";
import {FormForInputUserInformation} from "../../../AdditionalComponents/FormForInputUserInfo/FormForInputUserInformation";
import React from "react";

export const EditDataFormComponent = (props) => {
    return(
        <Grid item>
            <Typography
                align="center"
                variant="subtitle2"
                gutterBottom={true}
            >
                Fill or change only variables which you want to change
            </Typography>
            <FormForInputUserInformation
                {...props}
                submitButtonTitle   ="Edit"
                showEmailForm       ={true}
                showPasswordForm    ={true}
                showRoleForm        ={false}
                showFirstNameForm   ={true}
                showLastNameForm    ={true}
                showLicenceForm     ={true}
                showPhotoURLForm    ={true}
            />
        </Grid>
    )
};

export default EditDataFormComponent