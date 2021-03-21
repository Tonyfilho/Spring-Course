import { EmployeeInterface } from './../../assets/common/employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
 private apiServerUrl = '';
  constructor(private http: HttpClient) { };

  public getEmployees(): Observable<EmployeeInterface[]> {
    return this.http.get<EmployeeInterface[]>(`${this.apiServerUrl}/employee/`);
  }

  public addEmployee(employee: EmployeeInterface): Observable<EmployeeInterface>{
    return this.http.post<EmployeeInterface>(`${this.apiServerUrl}/employee/add`, employee);
  }

  public updateEmployee(employee: EmployeeInterface): Observable<EmployeeInterface>{
    return this.http.put<EmployeeInterface>(`${this.apiServerUrl}/employee/update`, employee);
  }

  public deleteEmployee(employeeId: number):Observable<void>{
   return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`);
  }

  










}//end class
