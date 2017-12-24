import {TestBed} from '@angular/core/testing';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import WelcomeComponent from './welcome.component';

describe('WelcomeComponent', () => {
  it('should show the username', () => {
    const store = {select: () =>
        Observable.of({name: 'foo'})
    };

    const fixture = TestBed
      .configureTestingModule(({
        declarations: [WelcomeComponent],
        providers: [
          {provide: Store, useValue: store}
        ]
      }))
      .createComponent(WelcomeComponent);
    const app = fixture.componentInstance;
    const spy = spyOn(fixture.debugElement.injector.get(Store), 'select')
      .and.callThrough();
    app.ngOnInit();
    const stateSelectorFn: (any) => any = spy.calls.mostRecent().args[0];
    const storeSelectorReturner = stateSelectorFn({app: {user: 'foo'}});
    fixture.detectChanges();
    expect(fixture.debugElement.nativeElement.innerText).toEqual('Willkommen foo');
    expect(storeSelectorReturner).toBe('foo');
  });
});
