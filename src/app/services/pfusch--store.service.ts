import {Injectable} from '@angular/core';
/**
 * Should be replaced by a more professional store implementation like Redux.
 */
@Injectable()
export class PfuschStore {
  private store: { [key: string]: any } = {};

  public put(key: string, value: any) {
    this.store[key] = value;
  }

  public get(key: string) {
    return this.store[key];
  }

}
