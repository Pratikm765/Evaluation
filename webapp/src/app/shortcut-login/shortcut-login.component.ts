import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Router} from "@angular/router";
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-shortcut-login',
  templateUrl: './shortcut-login.component.html',
  styleUrls: ['./shortcut-login.component.css'],
  providers: [UserService]
})

export class ShortcutLoginComponent implements OnInit {
  user:User={ name:"",email:"",password:""};
  errstr:string="";

  constructor(private route:ActivatedRoute, private router:Router, private userService:UserService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => { 
      this.user.email=params.get('id');
      this.userService.checkUserExists(this.user).subscribe(user=>
        {
          console.log(user.name)
          if(user.name.length == 0)
            this.router.navigate(['register']);
        });
  });
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
