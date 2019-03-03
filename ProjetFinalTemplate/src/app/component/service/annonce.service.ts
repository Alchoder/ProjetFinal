import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Annonce } from '../annonce/annonce';
import { User } from '../inscription/user';
import { Observable } from 'rxjs';
import { AnnonceInt } from '../annonce/annonceInt';
import { Annonce1 } from '../annonce/annonce.1';
const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': localStorage.getItem('token')
  })
}

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {
  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    const body = res;
    return body || { };
  }
  url= "http://localhost:8080/";
  getAllAnnonce(){
    return this.http.get("http://localhost:8080/getList/findAllAnnonce").pipe(map(this.extractData));
  }
  getUserAnnonce(user:string){
    return this.http.get("http://localhost:8080/gestionAnnonces/listByUser?idUser="+user,httpOptions).pipe(map(this.extractData));
  }
  addAnnonce(annonce: Annonce){
    return this.http.post(this.url+"gestionAnnonces/creation",annonce,httpOptions).pipe(map(this.extractData));
  }
  modifAnnonce(annonce: Annonce1){
    return this.http.post(this.url+"gestionAnnonces/creation",annonce,httpOptions).pipe(map(this.extractData));
  }
  supprimerAnnonce(id:number){
    return this.http.delete(this.url+"gestionAnnonces/delete?id="+id,httpOptions).pipe(map(this.extractData));
  }
  getUser(id:number){
    return this.http.get(this.url+"gestionUtilisateur/findById?id="+id,httpOptions).pipe(map(this.extractData));
  }
  getAnnonce(id:any){
    return this.http.get(this.url+"gestionAnnonces/TheChosenOne?id="+id,httpOptions).pipe(map(this.extractData));
  }
  getAnnoncee(id:any){
    return this.http.get(this.url+"gestionAnnonces/TheChosen?id="+id,httpOptions).pipe(map(this.extractData));
  }
  public GetAllAnnonces() {  
    return this.http.get(this.url +"getList/findAllAnnonce").pipe(map(this.extractData));     
  }
  
//   GetAllAnnoncees(
//     nomDpt,filter='', sortOrder='asc'
//  ,pageNumber = 0, pageSize = 3):   Observable<AnnonceInt[]> {  
//    return this.http.get(this.url +'getList/findAllAnnonce',{
//      params: new HttpParams()
//      .set('nomDpt',nomDpt.toString())
//      .set('filter',filter)
//      .set('sortOrder',sortOrder)
//      .set('pageNumber',pageNumber.toString())
//      .set('pageSize',pageSize.toString())
//    }).pipe(
//       map(res =>  res["payload"],this.extractData)
//    );
    
//  }  
}
