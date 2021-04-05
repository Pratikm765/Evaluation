import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor( private http: HttpClient) { }
  
  checkUserExists(user: User) : Observable< User>{
    return this.http.get<User>("http://localhost:5000/api/userExists?id="+user.email)
  }

  validatePassword(user: User) : Observable< string>{
    return this.http.post<string>("http://localhost:5000/api/validatePassword",user)
  }

  addUser(user: User) : Observable< boolean>{
    return this.http.post<boolean>("http://localhost:5000/api/addUser",user)
  }

  verifyEmail(user:User): Observable<boolean>{
    return this.http.post<boolean>("http://localhost:5000/api/verifyEmail",user)
  }

}
