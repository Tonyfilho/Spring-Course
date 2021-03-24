import { EmployeeServiceService } from './../employee-service.service';
import { Component, OnInit } from '@angular/core';
import { EmployeeInterface } from 'src/assets/common/employee';
import { HttpErrorResponse, HttpHeaderResponse } from '@angular/common/http';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
})
export class EmployeeComponent implements OnInit {
  public employeeList: EmployeeInterface[] = [];

  constructor(private service: EmployeeServiceService) {}

  ngOnInit(): void {
    this.service.getEmployees().subscribe(
      (data: EmployeeInterface[]) => {
        (this.employeeList = data), console.log(this.employeeList);
      },
      (error: HttpErrorResponse) => {
        console.error(error.message);
      },
      () => {
        new HttpHeaderResponse().status;
      }
    );

  }

} // end class
