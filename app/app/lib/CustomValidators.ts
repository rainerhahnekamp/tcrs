import {FormGroup, ValidatorFn} from "@angular/forms";

export default class CustomValidators {
  static confirmPassword(namePassword1: string = "password",
                         namePassword2: string = "passwordConfirmation"): ValidatorFn {
    return (abstractControl: FormGroup): {[key: string]: any} => {
      let password = abstractControl.get(namePassword1);
      let passwordConfirmation = abstractControl.get(namePassword2);

      if (!password || !passwordConfirmation) {
        return null;
      }
      if (password.value !== passwordConfirmation.value) {
        passwordConfirmation.setErrors({passwordConfirmation: "Password doesn't match"});
      }
    };
  }
}
