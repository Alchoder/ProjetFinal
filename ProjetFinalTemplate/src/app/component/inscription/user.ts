export class User {
    constructor(public nomUtilisateur:string,
         public prenomUtilisateur:string ,
          public login:string, 
          public password:string,
          public dateDeNaissance:string,
          public numVoie:number,
          public rue: string,
          public codePostal:string,
          public ville:string,
          public telephone:string,
          public PhotoProfil:string,
          public annonces:[any]){}
}
