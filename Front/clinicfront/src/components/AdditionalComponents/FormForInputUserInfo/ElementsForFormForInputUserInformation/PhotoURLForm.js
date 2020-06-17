import {Col, Form} from "react-bootstrap";
import React, {useState} from "react";
import StylesTextField from "../../CustomTextField/StylesTextField";
import TextFieldCustomTypography from "../../CustomTypography/TypesOfCustomTypography/TextFieldLabelCustomTypography";

export const PhotoURLForm = (props) => {
    const { handleChange, validation, userInformation, setIsCorrectInputInForms} = props;

    const [isCorrectInput, setIsCorrectInput] = useState(true);
    const [messageForIncorrectInput, setMessageForIncorrectInput] = useState(null);

    const setGoodInputInAllStates = () => {
        setIsCorrectInput(true);
        setIsCorrectInputInForms({photoUrlForm: true});
    };

    const setWrongInputInAllStates = () => {
        setIsCorrectInput(false);
        setIsCorrectInputInForms({photoUrlForm: false});
    };

    //Validation for input data
    const checkInputCorrect = (e) => {
        if (e.target.value.length === 0){
            setWrongInputInAllStates();
            setMessageForIncorrectInput("The field cannot be empty")
        } else {
            setGoodInputInAllStates();
            setMessageForIncorrectInput(null);
        }
    };
    return (
        <Form.Group as={Col}>
            <StylesTextField
                onChange={(e) => {
                    handleChange({photoUrl : e.target.value});
                    if (validation){checkInputCorrect(e)}
                }}
                name="photoUrl"
                label={
                    <TextFieldCustomTypography
                      primaryLabel={"Link do zdjęcia"}
                      secondaryLabel={"Photo URL"}
                    />
                }
                variant="outlined"
                error={!isCorrectInput}
                helperText={messageForIncorrectInput}
                fullWidth
                defaultValue={(userInformation) ? (userInformation.photoUrl) : null}
            />
        </Form.Group>)
};