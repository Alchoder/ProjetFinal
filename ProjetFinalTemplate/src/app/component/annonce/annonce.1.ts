export class Annonce1 {
    constructor(public idAnnonce:any,
        public titreAnnonce:string,
         public description:string ,
          public prix:number,
          public imageAnnonce:string,

          public dpt:{idDpt:number},
          public utilisateur:{idUtilisateur:any}
          ){}
}
