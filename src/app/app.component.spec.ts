import {inject, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {MatIconModule, MatMenuModule, MatToolbarModule} from '@angular/material';
import {UserService} from './services/user-service.service';
import {RouterTestingModule} from '@angular/router/testing';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

describe('AppComponent', () => {
  const userServiceStub = {logout: () => {}};
  const store = {
    select: () => Observable.of({isLoggedIn: true})
  };

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [MatMenuModule, MatIconModule, MatToolbarModule, RouterTestingModule],
      providers: [
        {provide: UserService, useValue: userServiceStub},
        {provide: Store, useValue: store}
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
    expect(app.isLoggedIn).toBeTruthy();
  });

  it('should redirect when click on logout', (inject([Router], router => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    const userService = fixture.debugElement.injector.get(UserService);
    const spy = spyOn(userService, 'logout');
    app.logout();
    expect(spy).toHaveBeenCalled();
  })));

  it('should initiate the component', () => {
    expect(new AppComponent(null, null)).toBeTruthy();
  });
});
