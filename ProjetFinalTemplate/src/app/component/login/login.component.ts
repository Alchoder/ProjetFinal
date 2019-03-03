import { RouterModule , Router, ActivatedRoute } from '@angular/router';

import { Component, OnInit } from '@angular/core';

import { first } from 'rxjs/operators';
import { LoginServiceService } from '../service/login-service.service';



@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html',
  styleUrls: ['./css/main.css','./css/util.css','./fonts/font-awesome-4.7.0/css/font-awesome.min.css','./vendor/animate/animate.css','./vendor/animsition/css/animsition.min.css','./vendor/css-hamburgers/hamburgers.min.css','./vendor/select2/select2.min.css'],
  providers: [LoginServiceService]
})
export class LoginComponent implements OnInit {
  user: string;

  constructor(private service : LoginServiceService , private routes: Router, private activatedRoute: ActivatedRoute) { }
  msg;
  loading = false;
  submitted = false;
  uname;
  p;
  login;
  error;
  returnUrl: string;
  uti;
  ngOnInit() {
  }
  check() {
    this.submitted = true;
    this.loading = true;
    let username=this.uname;
    this.service.checkusernameandpassword(this.uname, this.p).pipe(first()).subscribe(
      data => {
        localStorage.setItem("token", data.headers.get('Authorization'));
        localStorage.setItem("user", username);
        
        this.routes.navigate(['/starter']);
        console.log("local:",localStorage.getItem('user'));
        // console.log("local:",localStorage.getItem('token'));
        
        alert("Vous êtes bien connecté "+localStorage.getItem("user"));
        this.getUser(this.uname);
        location.reload();  
      },
      error => {
        this.error = error;
        this.loading = false;
        console.log("Vérifiez vos données");
        this.msg ="Vérifiez vos données";
      });
    
        
  }
  getUser(user:string){
    this.service.getUserByLogin(user).subscribe((data3:{})=>{
      this.uti=data3;
      localStorage.setItem("Utilisateur",this.uti);
      localStorage.setItem("idUser",this.uti.idUtilisateur);
      console.log(localStorage.getItem("Utilisateur"))
    } );
  }
  
}