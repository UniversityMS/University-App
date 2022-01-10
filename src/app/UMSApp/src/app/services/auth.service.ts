import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _loginUrl = "http://localhost:8080/login"
  constructor(private http: HttpClient) { }

  loginEmployee(employee) {
    return this.http.post<any>(this._loginUrl, employee)
  }

  // loginStudent(student) {
  //   return this.http.post<any>(this._loginUrl, student)
  // }
}
