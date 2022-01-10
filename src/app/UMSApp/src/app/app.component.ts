import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, startWith } from 'rxjs/operators';
import { Employee } from './services/employee';
import { EmployeesService } from './services/employee.service';
import { Student } from './services/student';
import { StudentsService } from './services/student.service';
// import { DataState } from './enum/data-state.enum';
// import { AppState } from './interface/app-state';
// import { CustomResponse } from './interface/custom-response';
// import { ServerService } from './service/server.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  employees: Employee[];
  students: Student[];

  constructor(private employeeService: EmployeesService, private studentService: StudentsService){}
  //constructor(private studentService: StudentsService){}

  ngOnInit() {
    this.getEmployees();
    this.getStudents();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getStudents(): void {
    this.studentService.getStudents().subscribe(
      (response: Student[]) => {
        this.students = response;
        console.log(this.students);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
