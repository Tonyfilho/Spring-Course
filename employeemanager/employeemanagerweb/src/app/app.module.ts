import { EmployeeModule } from './employee/employee.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    EmployeeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
