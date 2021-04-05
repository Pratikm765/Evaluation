import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-verify-email',
  templateUrl: './verify-email.component.html',
  styleUrls: ['./verify-email.component.css'],
  providers: [UserService]
})
export class VerifyEmailComponent implements OnInit {

  user:User={ name:"",email:"",password:""};
  constructor(private route:ActivatedRoute, private userService:UserService,private router:Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => { 
      this.user.email=params.get('email');
     });
  }

  verifyEmail(){
    this.userService.verifyEmail(this.user).subscribe(isVerified=>{
      if(isVerified)
      {
        console.log("Verified Successfully");
        this.router.navigate(['']);
      }
        

    });
  }

}
