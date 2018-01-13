import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Configuration } from './configuration';

import { BasicErrorControllerService } from './api/basicErrorController.service';
import { ClubsControllerService } from './api/clubsController.service';
import { ReservationControllerService } from './api/reservationController.service';
import { SecurityControllerService } from './api/securityController.service';
import { TestControllerService } from './api/testController.service';

@NgModule({
  imports:      [ CommonModule, HttpClientModule ],
  declarations: [],
  exports:      [],
  providers: [
    BasicErrorControllerService,
    ClubsControllerService,
    ReservationControllerService,
    SecurityControllerService,
    TestControllerService ]
})
export class ApiModule {
    public static forRoot(configurationFactory: () => Configuration): ModuleWithProviders {
        return {
            ngModule: ApiModule,
            providers: [ { provide: Configuration, useFactory: configurationFactory } ]
        }
    }

    constructor( @Optional() @SkipSelf() parentModule: ApiModule) {
        if (parentModule) {
            throw new Error('ApiModule is already loaded. Import your base AppModule only.');
        }
    }
}
