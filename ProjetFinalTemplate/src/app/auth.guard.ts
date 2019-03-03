import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CanDeactivate } from '@angular/router/src/utils/preactivation';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate /*,CanDeactivate*/ {
  component: Object;
  route: ActivatedRouteSnapshot;
 constructor(private routes : Router){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if(localStorage.getItem('token')!=null){
        return true;
      }
      else{
        alert("Vous n'avez pas accès à ces fonctionnalités, veuillez-vous connecter")
        this.routes.navigate(['/component/login']);
        return false;
      }
  }
//   canDeactivate(next: ActivatedRouteSnapshot,
//     state: RouterStateSnapshot):
// Observable<boolean> | Promise<boolean> | boolean {
//       if(localStorage.getItem('token')==null){
//         return true;

//       }
//       else{
//         alert("Vous n'avez pas accès à ces fonctionnalités");
//         this.routes.navigate(['/starter']);
//         return false
//       }

  
// }
}