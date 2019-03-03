import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../inscription/user';
import { map } from 'rxjs/operators';
const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': localStorage.getItem('token')
  })
}
@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  
  private extractData(res: Response) {
    const body = res;
    return body || { };
  }
  url= "http://localhost:8080/";
  constructor(private http: HttpClient) { }
  checkusernameandpassword(uname: string, p : string){
    
    return this.http.post("http://localhost:8080/login",{login:uname,password:p},{observe:'response'});
    
  }
  Inscription(user:User){
    console.log("Un nouvel utilisateur a été créé");
    return this.http.post("http://localhost:8080/gestionUtilisateur/adduser",user).pipe(map(this.extractData));
 
  }
  getUserByLogin(login:string){
    return this.http.get(this.url+"gestionUtilisateur/findOne?login="+login,httpOptions).pipe(map(this.extractData));
  }
}
