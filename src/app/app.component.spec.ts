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
    select: (fn) => Observable.of({isLoggedIn: true})
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
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.isLoggedIn).toBeFalsy();
    const spy = spyOn(fixture.debugElement.injector.get(Store), 'select')
      .and.callThrough();
    app.ngOnInit();
    const stateSelectorFn: (any) => any = spy.calls.mostRecent().args[0];
    const storeSelectorReturner = stateSelectorFn({app: {user: 'foo'}});
    expect(app.isLoggedIn).toBeTruthy();
    expect(storeSelectorReturner).toBe('foo');
  });

  it('should redirect when click on logout', (inject([Router], router => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    const spy = spyOn(fixture.debugElement.injector.get(UserService), 'logout');
    app.logout();
    expect(spy).toHaveBeenCalled();
  })));

  it('should initiate the component', () => {
    expect(new AppComponent(null, null)).toBeTruthy();
  });
});
