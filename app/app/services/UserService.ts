import {Endpoint} from "./Endpoint";
import {Injectable} from "@angular/core";
/**
 * main service method for fetching data about the current logged in user.
 */

@Injectable()
export class UserService {
  constructor(private endpoint: Endpoint) {

  }

  getUser() {
    return this.endpoint.get("user");
  }

  logout() {
    return this.endpoint.post("logout");
  }
}
