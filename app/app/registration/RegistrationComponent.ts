import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import CustomValidators from "../lib/CustomValidators";

@Component({
  templateUrl: "registration.html"
})
export default class RegistrationComponent implements OnInit {
  form: FormGroup;

  constructor(private formBuilder: FormBuilder) {

  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      email: ["", Validators.email],
      password: ["", Validators.required],
      passwordConfirmation: ["", Validators.required]
    }, {
      validator: CustomValidators.confirmPassword()
    });
  }

  onSubmit() {
    if (this.form.valid) {
      console.log("form valid");
    }
  }


}
