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

  constructor(private service: EmployeeServiceService) { }

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

  public onOpenModal(employee: EmployeeInterface, mode: string): void {
    
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-toggle', '#addEmployeeModal');
      console.log('dentro do add ');

    }
    if (mode === 'edit') {
      button.setAttribute('data-toggle', '#updateEmployeeModal');
      console.log('dentro do edit');

    }
    if (mode === 'delete') {
      button.setAttribute('data-toggle', '#deleteEmployeeModal');
      console.log('dentro do delete ');

    }
    container.appendChild(button);
    button.click();
  }

} // end class
