import React from "react";
import {Badge, Container, Row} from "react-bootstrap";
import {List, ListItemText, Typography,} from "@material-ui/core";
import TextFieldCustomTypography from "../CustomTypography/TypesOfCustomTypography/TextFieldLabelCustomTypography";
import ButtonCustomTypography from "../CustomTypography/TypesOfCustomTypography/ButtonCustomTypography";

export const ContainerForUserInformation = (props) => {

  const {
    userInformation,
    firstName,
    lastName,
    licence,
    specializations,
    pesel,
    primaryTitleRole,
    secondaryTitleRole
  } = props;

  //CSS stylesheet
  const styleForContainer = {
    color: 'black',
    padding: '10px 30px 10px 30px',
    marginBottom: '15px',
    width: '50%',
    border: '2px solid #4d1919',
    borderRadius: '7px',
  };

  //Main HTML return
  const displaySpecializations = () => {
    let specializationsShow = '';
    for (let item in userInformation.specializations) {
      if (userInformation.specializations.hasOwnProperty(item)) {
        specializationsShow += userInformation.specializations[item].name + "  ";
      }
    }
    return specializationsShow;
  };

  const displayEachInfo = (info, primaryTitle, secondaryTitle) => {
    let value;
    if (secondaryTitle === "Specializations") {
      value = displaySpecializations();
    } else {
      value = info;
    }
    return (
      <ListItemText
        primary={
          <React.Fragment>
            <TextFieldCustomTypography
              primaryLabel={primaryTitle}
              secondaryLabel={secondaryTitle}
            />
          </React.Fragment>
        }
        secondary={
          <React.Fragment>
            <Typography
              component="span"
              variant="h6"
              style={{color: "#4d1919"}}
            >
              {info ? (value) : null}
            </Typography>
          </React.Fragment>
        }
      />
    )
  };

  return (
    <Container style={styleForContainer}>
      <List>
        <Row>
          <h5>
            <Badge variant="primary" style={{backgroundColor: "#4d1919"}}>
              <ButtonCustomTypography
                primaryLabel={primaryTitleRole}
                secondaryLabel={secondaryTitleRole}
              />
            </Badge>
          </h5>
        </Row>
        {firstName ? (displayEachInfo(userInformation.firstName, "Imię" ,"First Name")) : null}
        {lastName ? (displayEachInfo(userInformation.lastName, "Nazwisko","Last Name")) : null}
        {licence ? (displayEachInfo(userInformation.licence, "Licencja","Licence")) : null}
        {specializations ? (displayEachInfo(userInformation.specializations, "Specjalizacje","Specializations")) : null}
        {pesel ? (displayEachInfo(userInformation.pesel, "Pesel","Pesel")) : null}
      </List>
    </Container>

  )
};