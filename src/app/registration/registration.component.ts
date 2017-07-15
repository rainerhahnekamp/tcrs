import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import CustomValidators from '../../lib/CustomValidators';

@Component({
  templateUrl: 'registration.component.html'
})
export default class RegistrationComponent implements OnInit {
  form: FormGroup;
  email: FormControl;
  password: FormControl;
  passwordConfirmation: FormControl;

  constructor(private formBuilder: FormBuilder) {

  }

  ngOnInit() {
    this.email = this.formBuilder.control('', Validators.email);
    this.password = this.formBuilder.control('', Validators.compose(
      [Validators.minLength(8), CustomValidators.passwordComplexity]));
    this.passwordConfirmation = this.formBuilder.control('');
    this.form = this.formBuilder.group({
      email: this.email,
      password: this.password,
      passwordConfirmation: this.passwordConfirmation
    }, {
      validator: CustomValidators.confirmPassword()
    });
  }

  onSubmit() {
    if (this.form.valid) {

    }
  }
}
