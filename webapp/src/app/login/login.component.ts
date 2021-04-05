import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [UserService]
})
export class LoginComponent implements OnInit {
  user:User={ name:"",email:"",password:""};
  errstr:string="";

  constructor(private userService:UserService, private router:Router) { }

  ngOnInit() {
  }
  
  login(){
    this.userService.validatePassword(this.user).subscribe(token=>
      {
        if(token.length>0)
        {
          localStorage.setItem('user',token);
          this.router.navigate(['dashboard']);
        }
        else
          this.errstr="Password Invalid";
      }
    );
  }

}
