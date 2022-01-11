import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from 'src/app/services/employee';
import { EmployeesService } from 'src/app/services/employee.service';
import { StudentsService } from 'src/app/services/student.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  // public employees: Employee[];
  // public editEmployee: Employee;
  // public deleteEmployee: Employee;

  // constructor(private employeeService: EmployeesService) { }

  ngOnInit(): void {
    //this.getEmployees();
    //this.getStudents();
  }

  // public getEmployees(): void {
  //     this.employeeService.getEmployees().subscribe(
  //       (response: Employee[]) => {
  //         this.employees = response;
  //         console.log(this.employees);
  //       },
  //       (error: HttpErrorResponse) => {
  //         alert(error.message);
  //       }
  //     );
  //   }
  
  //   public onAddEmloyee(addForm: NgForm): void {
  //     document.getElementById('add-employee-form').click();
  //     this.employeeService.addEmployee(addForm.value).subscribe(
  //       (response: Employee) => {
  //         console.log(response);
  //         this.getEmployees();
  //         addForm.reset();
  //       },
  //       (error: HttpErrorResponse) => {
  //         alert(error.message);
  //         addForm.reset();
  //       }
  //     );
  //   }
  
  //   public onUpdateEmloyee(employee: Employee): void {
  //     this.employeeService.updateEmployee(employee).subscribe(
  //       (response: Employee) => {
  //         console.log(response);
  //         this.getEmployees();
  //       },
  //       (error: HttpErrorResponse) => {
  //         alert(error.message);
  //       }
  //     );
  //   }
  
  //   public onDeleteEmloyee(employeeId: number): void {
  //     this.employeeService.deleteEmployee(employeeId).subscribe(
  //       (response: void) => {
  //         console.log(response);
  //         this.getEmployees();
  //       },
  //       (error: HttpErrorResponse) => {
  //         alert(error.message);
  //       }
  //     );
  //   }
  
  //   public searchEmployees(key: string): void {
  //     console.log(key);
  //     const results: Employee[] = [];
  //     for (const employee of this.employees) {
  //       if (employee.firstName.toLowerCase().indexOf(key.toLowerCase()) !== -1
  //       || employee.lastName.toLowerCase().indexOf(key.toLowerCase()) !== -1
  //       )
  //        {
  //         results.push(employee);
  //       }
  //     }
  //     this.employees = results;
  //     if (results.length === 0 || !key) {
  //       this.getEmployees();
  //     }
  //   }
  
  //   public onOpenModal(employee: Employee, mode: string): void {
  //     const container = document.getElementById('main-container');
  //     const button = document.createElement('button');
  //     button.type = 'button';
  //     button.style.display = 'none';
  //     button.setAttribute('data-toggle', 'modal');
  //     if (mode === 'add') {
  //       button.setAttribute('data-target', '#addEmployeeModal');
  //     }
  //     if (mode === 'edit') {
  //       this.editEmployee = employee;
  //       button.setAttribute('data-target', '#updateEmployeeModal');
  //     }
  //     if (mode === 'delete') {
  //       this.deleteEmployee = employee;
  //       button.setAttribute('data-target', '#deleteEmployeeModal');
  //     }
  //     container.appendChild(button);
  //     button.click();
  //   }
  
}
