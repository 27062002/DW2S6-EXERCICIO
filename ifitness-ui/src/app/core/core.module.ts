import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthService } from '../security/auth.service';
import { ActivityService } from '../activities/activity.service';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    NavbarComponent
  ],
  imports: [
    CommonModule
  ],

  exports:[
    NavbarComponent
  ],

  providers: [
    AuthService,
    ActivityService
  ]
})
export class CoreModule { }
