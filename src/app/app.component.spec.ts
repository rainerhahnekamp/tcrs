import {async, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {MdMenuModule} from '@angular/material';
import {UserService} from './services/user-service.service';
import {RouterTestingModule} from '@angular/router/testing';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [MdMenuModule, RouterTestingModule],
      providers: [
        {provide: UserService, useValue: {getObservable: () => ({subscribe: () => true})}}
      ]
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should set user info when user info is available', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
});
