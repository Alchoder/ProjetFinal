import { Component, OnInit } from '@angular/core';
import { AnonymousService } from '../service/anonymous.service';
import { Router } from '@angular/router';
import { Annonce } from './annonce';
import { AnnonceService } from '../service/annonce.service';
import { LoginServiceService } from '../service/login-service.service';

@Component({
  selector: 'app-annonce',
  templateUrl: './annonce.component.html'
})
export class AnnonceComponent implements OnInit {
listDpt;
titreAnnonce;
description;
prix;
imageAnnonce;
dpt;
nouvelAnnonce;
uti;
error: {};
user=localStorage.getItem("user");
picture;
selectedFile=new ImageSnippet('',null);
  constructor(private serviceAnonymous : AnonymousService,private annServ: AnnonceService , private loginServ : LoginServiceService, private routes : Router) { }
  getUserId(){
    this.loginServ.getUserByLogin(this.user).subscribe((data1:{})=>{
      this.uti=data1;
    console.log(this.uti.idUtilisateur);
    localStorage.setItem("idUser",this.uti.idUtilisateur);
    console.log(localStorage.getItem("idUser"));
    })
  }
  
    ngOnInit() {
      this.serviceAnonymous.getAllDpt().subscribe((data:{})=>{
        this.listDpt=data;
      this.getUserId();
      })
    }
  processFile(imageInput:any){
this.picture=imageInput;
const file:File =imageInput.files[0];
console.log(this.picture);
console.log(file);
const reader = new FileReader();
reader.addEventListener('load',(event:any)=>{
  this.selectedFile= new ImageSnippet(event.target.result,file);
  console.log(this.selectedFile);
})
reader.readAsDataURL(file);
  }

addAnnonce(){
  console.log("IdUser=" +localStorage.getItem("idUser"));
  this.nouvelAnnonce = new Annonce(this.titreAnnonce,this.description,this.prix,this.imageAnnonce,{"idDpt":this.dpt},{"idUtilisateur":localStorage.getItem("idUser")});
  this.annServ.addAnnonce(this.nouvelAnnonce).subscribe(
    ()=>{
      alert("Annonce ajoutée");
    },
    error=> {
      this.error=error;
      alert("A pas marché");
    }  );
}

}
