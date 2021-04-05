import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [UserService]
})
export class RegisterComponent implements OnInit {
  
  user:User={ name:"",email:"",password:""};
  confPass:string="";
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit() {
  }

  register(){
      this.userService.addUser(this.user).subscribe((success)=>
       { 
         if(success)
           this.router.navigate(['otp/'+this.user.email]);
      });
  }

}
