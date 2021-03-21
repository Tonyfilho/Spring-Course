import { EmployeeServiceService } from './employee-service.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeComponent } from './employee/employee.component';
import {HttpClientModule} from '@angular/common/http'
import { from } from 'rxjs';

@NgModule({
  declarations: [EmployeeComponent],
  imports: [CommonModule,
    HttpClientModule],
  providers: [EmployeeServiceService],
  exports: [EmployeeComponent]
})
export class EmployeeModule {}
