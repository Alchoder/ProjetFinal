import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AnonymousService {

  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    const body = res;
    return body || { };
  }
  getAllAnnonce():Observable<any>{
    console.log("La liste des annonces s'affiche")
    return this.http.get("http://localhost:8080/getList/findAllAnnonce").pipe(map(this.extractData));
  }
  getAllDpt():Observable<any>{
    console.log("La liste des dpts s'affiche")
    return this.http.get("http://localhost:8080/getList/findAllDpt").pipe(map(this.extractData));
  }
}
