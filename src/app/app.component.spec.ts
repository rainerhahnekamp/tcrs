import {fakeAsync, inject, TestBed, tick} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {MdMenuModule} from '@angular/material';
import {UserService} from './services/user-service.service';
import {RouterTestingModule} from '@angular/router/testing';
import {Router} from '@angular/router';
import createSpy = jasmine.createSpy;

describe('AppComponent', () => {
  let callback: (userInfo) => void;
  const subscribeFn = fn => callback = fn;
  const userService = {
    getObservable: createSpy('observable').and.returnValue({subscribe: subscribeFn}),
    logout: createSpy('logout').and.returnValue(new Promise(resolve => resolve()))
  };

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [MdMenuModule, RouterTestingModule],
      providers: [
        {provide: UserService, useValue: userService}
      ]
    });
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should set user info when user info is available', () => {
    const app = TestBed.createComponent(AppComponent).debugElement.componentInstance;
    expect(app.isLoggedIn).toBeFalsy();
    app.ngOnInit();
    callback({isLoggedIn: true});
    expect(app.isLoggedIn).toBeTruthy();
  });

  it('should redirect when click on logout', fakeAsync(inject([Router], router => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    const spy = spyOn(router, 'navigate');
    app.logout();
    tick();
    expect(spy).toHaveBeenCalledWith(['']);
  })));

  it('should initiate the component', () => {
    expect(new AppComponent(null, null)).toBeTruthy();
  });
});
