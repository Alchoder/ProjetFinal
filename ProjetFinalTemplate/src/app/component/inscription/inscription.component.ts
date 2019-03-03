import { Component, OnInit, ɵConsole } from '@angular/core';
import { LoginServiceService } from '../service/login-service.service';
import { User } from './user';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css', '../login/css/main.css', '../login/css/util.css', '../login/fonts/font-awesome-4.7.0/css/font-awesome.min.css', '../login/vendor/animate/animate.css', '../login/vendor/animsition/css/animsition.min.css', '../login/vendor/css-hamburgers/hamburgers.min.css', '../login/vendor/select2/select2.min.css']
})
export class InscriptionComponent implements OnInit {
  user: any;
  login: string;
  password: string;
  error: {};
  msg1: string;
  nomUtilisateur: string;
  prenomUtilisateur: string;
  dateDeNaissance = { year: String, month: String, day: String }
  numVoie: number;
  rue: string;
  codePostal: string;
  ville: string;
  telephone: string;
  PhotoProfil: string;
  annonces: [any];
  monthLength:number;
  constructor(private service: LoginServiceService) { }

  ngOnInit() {
  }
  Inscription() {

    let monthCorrected = ("0" + this.dateDeNaissance.month).toString();
    let dayCorrected = ("0" + this.dateDeNaissance.day).toString();
   let monthLength = monthCorrected.length;
   let dayLength=dayCorrected.length;
    if (monthLength == 2 && dayLength== 2) {
      let d = (this.dateDeNaissance.year + "-" + monthCorrected + "-" + dayCorrected).toString();
      this.user = new User(this.nomUtilisateur, this.prenomUtilisateur,
        this.login, this.password, d, this.numVoie, this.rue,
        this.codePostal, this.ville, this.telephone, this.PhotoProfil, this.annonces);
      localStorage.setItem("login", this.login);
      localStorage.setItem("username", this.nomUtilisateur);
      this.service.Inscription(this.user).subscribe(
        () => {

          console.log(localStorage.getItem("login"));
          console.log(this.login);
          console.log(localStorage.getItem("username"));
          alert("Bienvenue sur notre site " + localStorage.getItem("username") + " ,vous pouvez désormais vous connecter");
        },
        error => {
          this.error = error;
          alert("Déso y'a pas moy");
        }
      );

    }
    else if (monthLength== 2 || dayLength== 2) {
      if (monthLength== 2) {
        let d = (this.dateDeNaissance.year + "-" + monthCorrected + "-" + this.dateDeNaissance.day).toString();
        console.log(this.dateDeNaissance.day + "-" + this.dateDeNaissance.month);
        console.log(d);
        this.user = new User(this.nomUtilisateur, this.prenomUtilisateur,
          this.login, this.password, d, this.numVoie, this.rue,
          this.codePostal, this.ville, this.telephone, this.PhotoProfil, this.annonces);
        localStorage.setItem("login", this.login);
        localStorage.setItem("username", this.nomUtilisateur);
        this.service.Inscription(this.user).subscribe(
          () => {

            console.log(localStorage.getItem("login"));
            console.log(this.login);
            console.log(localStorage.getItem("username"));
            alert("Bienvenue sur notre site " + localStorage.getItem("username") + " ,vous pouvez désormais vous connecter");
          },
          error => {
            this.error = error;
            alert("Déso y'a pas moy");
          }
        );
      }
      else if (dayLength== 2) {
        let d = (this.dateDeNaissance.year + "-" + this.dateDeNaissance.month + "-" + dayCorrected).toString();
        console.log(this.dateDeNaissance.day + "-" + this.dateDeNaissance.month);
        console.log(d);
        this.user = new User(this.nomUtilisateur, this.prenomUtilisateur,
          this.login, this.password, d, this.numVoie, this.rue,
          this.codePostal, this.ville, this.telephone, this.PhotoProfil, this.annonces);
        localStorage.setItem("login", this.login);
        localStorage.setItem("username", this.nomUtilisateur);
        this.service.Inscription(this.user).subscribe(
          () => {

            console.log(localStorage.getItem("login"));
            console.log(this.login);
            console.log(localStorage.getItem("username"));
            alert("Bienvenue sur notre site " + localStorage.getItem("username") + " ,vous pouvez désormais vous connecter");
          },
          error => {
            this.error = error;
            alert("Déso y'a pas moy");
          }
        );
      }
      else {
        let d = (this.dateDeNaissance.year + "-" + this.dateDeNaissance.month + "-" + this.dateDeNaissance.day).toString();
        console.log(this.dateDeNaissance.day + "-" + this.dateDeNaissance.month);
        console.log(d);
        this.user = new User(this.nomUtilisateur, this.prenomUtilisateur,
          this.login, this.password, d, this.numVoie, this.rue,
          this.codePostal, this.ville, this.telephone, this.PhotoProfil, this.annonces);
        localStorage.setItem("login", this.login);
        localStorage.setItem("username", this.nomUtilisateur);
        this.service.Inscription(this.user).subscribe(
          () => {

            console.log(localStorage.getItem("login"));
            console.log(this.login);
            console.log(localStorage.getItem("username"));
            alert("Bienvenue sur notre site " + localStorage.getItem("username") + " ,vous pouvez désormais vous connecter");
          },
          error => {
            this.error = error;
            alert("Déso y'a pas moy");
          }
        );
      }
    }
  }
}
