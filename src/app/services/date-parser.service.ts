import {Injectable} from '@angular/core';
import * as _ from 'lodash';

@Injectable()
export class DateParser {
  constructor() {

  }

  public parse(object: Object): Object {
    if (_.isObject(object)) {
      _.forOwn(object, function (value, key) {
        if (_.isObject(object[key])) {
          object[key] = this.parse(object[key]);
        } else {
          if (key.match(/datetime/gi)) {
            object[key] = new Date(object[key] * 1000);
          }
        }
      });
    }
    return object;
  }

}
