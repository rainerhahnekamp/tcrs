import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from "@angular/material";
import { AppComponent } from './app/app';
import { CalendarNavigatorComponent } from './calendar-navigator/calendar-navigator.component';
import { CalendarComponent } from './calendar/calendar.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule.forRoot()
  ],
  declarations: [AppComponent, CalendarNavigatorComponent, CalendarComponent],
  bootstrap: [AppComponent],
  providers: [
    {provide: LOCALE_ID, useValue: window.navigator.language}
  ]
})
export class AppModule { }
