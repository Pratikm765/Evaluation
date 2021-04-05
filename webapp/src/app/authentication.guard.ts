import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationGuard implements CanActivate {
  constructor(private router: Router){

  }
  canActivate(): boolean{
    if(localStorage.getItem('user'))
     return true;
    else
     this.router.navigate(['login']);
  }
  
}
