import {TextField, withStyles} from "@material-ui/core";

const CustomTextField = withStyles({
  root: {
    '& label.Mui-focused': {
      color: "#4d1919",
    },
    '& .MuiOutlinedInput-root': {
      '&.Mui-focused fieldset': {
        borderColor: "#4d1919",
      },
    },
  }
})(TextField);

export default CustomTextField