import {Injectable} from "@angular/core";
import {ActivatedRoute} from "@angular/router";

@Injectable()
export class UrlService {
  constructor(private activatedRoute: ActivatedRoute) {}

  getCurrentClub(): string {
    return this.activatedRoute.root.firstChild.snapshot.params["club"];
  }
}
