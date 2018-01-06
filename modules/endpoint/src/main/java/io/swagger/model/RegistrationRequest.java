package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RegistrationRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-06T22:03:33.269Z")

public class RegistrationRequest   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("passwordConfirmation")
  private String passwordConfirmation = null;

  public RegistrationRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RegistrationRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RegistrationRequest passwordConfirmation(String passwordConfirmation) {
    this.passwordConfirmation = passwordConfirmation;
    return this;
  }

  /**
   * Get passwordConfirmation
   * @return passwordConfirmation
  **/
  @ApiModelProperty(value = "")


  public String getPasswordConfirmation() {
    return passwordConfirmation;
  }

  public void setPasswordConfirmation(String passwordConfirmation) {
    this.passwordConfirmation = passwordConfirmation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationRequest registrationRequest = (RegistrationRequest) o;
    return Objects.equals(this.email, registrationRequest.email) &&
        Objects.equals(this.password, registrationRequest.password) &&
        Objects.equals(this.passwordConfirmation, registrationRequest.passwordConfirmation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, passwordConfirmation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationRequest {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    passwordConfirmation: ").append(toIndentedString(passwordConfirmation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

