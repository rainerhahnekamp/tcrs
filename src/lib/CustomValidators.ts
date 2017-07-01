import {FormControl, FormGroup, ValidatorFn} from '@angular/forms';

export default class CustomValidators {
  static confirmPassword(namePassword1: string = 'password',
                         namePassword2: string = 'passwordConfirmation'): ValidatorFn {
    return (abstractControl: FormGroup): {[key: string]: any} => {
      const password = abstractControl.get(namePassword1);
      const passwordConfirmation = abstractControl.get(namePassword2);

      if (!password || !passwordConfirmation) {
        return null;
      }
      if (password.value !== passwordConfirmation.value) {
        passwordConfirmation.setErrors({passwordConfirmation: 'Password doesn\'t match'});
      }
    };
  }

  static passwordComplexity(passwordControl: FormControl): {[key: string]: any} {
    if (passwordControl.errors && passwordControl.errors['minlength']) {
      console.log(passwordControl.errors.minlength);
    }
    const password = passwordControl.value;
    if (password.match(/[0-9]/) && password.match(/[a-zA-Z]/)) {
      return null;
    } else {
      return {passwordComplexity: 'The password must contain at least one number and letter'};
    }
  }
}
