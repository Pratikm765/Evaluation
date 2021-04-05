import { Component, OnInit } from '@angular/core';
import { element, ElementHelper } from 'protractor';
import { Inject }  from '@angular/core';
import { DOCUMENT } from '@angular/common'; 
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  email:string;

  constructor( private router:Router ) { 
  }

  ngOnInit() {
  }

  hidebar(){
    document.getElementById("navlinks").style.visibility="hidden";
  }
  showbar(){
    document.getElementById("navlinks").style.visibility="visible";
  }
  focusInput(){
    document.getElementById("my_textbox").focus();
  }

  gotoDashboard(){
    this.router.navigate(['dashboard']);
  }

}
