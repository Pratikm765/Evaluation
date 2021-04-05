import { Component, OnInit } from '@angular/core';
import { element } from 'protractor';

@Component({
  selector: 'app-dashboard-main',
  templateUrl: './dashboard-main.component.html',
  styleUrls: ['./dashboard-main.component.css']
})
export class DashboardMainComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  editable(){
    document.getElementById("savable").removeAttribute("disabled");
    var elements = document.getElementsByClassName("editable");
    for(var i=0; i<elements.length; i++) {
      elements[i].removeAttribute("disabled");
  }
  }

  savable(){
    document.getElementById("savable").setAttribute("disabled","disabled");
    var elements = document.getElementsByClassName("editable");
    for(var i=0; i<elements.length; i++) {
      elements[i].setAttribute("disabled","disabled");
  }
  }
}
