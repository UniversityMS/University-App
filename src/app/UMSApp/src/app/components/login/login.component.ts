import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginEmployeeData = {}
  constructor(private _auth: AuthService) { }

  ngOnInit(): void {
  }

  loginEmployee(){
    this._auth.loginEmployee(this.loginEmployeeData)
  .subscribe(
    res => console.log(res),
    err => console.log(err)
  )
  }
}
