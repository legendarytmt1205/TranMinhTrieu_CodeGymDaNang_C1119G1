import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MAT_DATE_LOCALE,MAT_DATE_FORMATS,DateAdapter} from '@angular/material/core';
// import { AngularFireAnalyticsModule} from '@angular/fire/analytics';
// import { AngularFireModule} from '@angular/fire';
// import { AngularFirestoreModule} from '@angular/fire/firestore';
import { environment} from '../environments/environment';





@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'en-GB'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
