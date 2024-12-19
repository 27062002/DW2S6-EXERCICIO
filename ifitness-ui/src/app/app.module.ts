import { CoreModule } from './core/core.module';
import { AuthService } from './security/auth.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ActivitiesModule } from './activities/activities.module';
import { SecurityModule } from './security/security.module';
import { HttpClientModule } from '@angular/common/http';
import { HomeModule } from './home/home.module';
import { UsersModule } from './users/users.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ActivitiesModule,
    SecurityModule,
    HttpClientModule,
    HomeModule,
    CoreModule,
    UsersModule
  ],
  providers: [
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
