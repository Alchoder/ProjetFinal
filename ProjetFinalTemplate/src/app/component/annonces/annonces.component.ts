import { Component, OnInit, ViewChild } from '@angular/core';
import { AnnonceService } from '../service/annonce.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { Annonce } from '../annonce/annonce';
import { JwtHelperService, JwtModule, JwtInterceptor, JWT_OPTIONS } from '@auth0/angular-jwt';

@Component({
  selector: 'app-annonces',
  templateUrl: './annonces.component.html',
  styleUrls: ['./annonces.component.css']
})
export class AnnoncesComponent implements OnInit {

  constructor(private serviceAnn: AnnonceService,private modalService: NgbModal,private route: Router) { }
listAnn;
closeResult: string;
ann;
numUser;
error;
dataSource = new MatTableDataSource([Annonce]);
MyDataSource: any;  
// MyDataSource = new MatTableDataSource([Annonce]);
displayedColumns = ['titreAnnonce', 'description','prix','image','nomDpt','contact'];
@ViewChild(MatSort) sort: MatSort;
@ViewChild(MatPaginator) paginator: MatPaginator;
  ngOnInit() {
    this.serviceAnn.getAllAnnonce().subscribe((data: {}) => {
      this.listAnn = data;
    });
    this.MyDataSource = new MatTableDataSource();
    // this.serviceAnn.GetAllAnnonces().subscribe(annonces => this.MyDataSource.data=annonces);  
    this.RenderDataTable();
    this.MyDataSource.paginator=this.paginator;
    this.MyDataSource.sort=this.sort;
  }
  RenderDataTable() {  
    this.serviceAnn.GetAllAnnonces()  
      .subscribe(annonces => this.MyDataSource.data=annonces);  
  }  
searchAnnonces(search=''){

  this.MyDataSource.filter=search.toLowerCase().trim();
  if (this.MyDataSource.paginator) {
    this.MyDataSource.paginator.firstPage();
  }
}

  onRowClicked(row) {
    console.log('Row clicked: ', row);
}

  open(content,idAnn) {
  this.serviceAnn.getAnnoncee(idAnn).subscribe((data:{})=>{
    
    this.ann=data;
    this.numUser=this.ann.utilisateur.telephone;
    this.modalService.open(content)
    
  },
  error=>{
    this.error=error;
    alert("Vous n'avez pas accès aux numéros des utilisateurs si vous n'êtes pas inscrit");
    this.route.navigate(['/component/inscription']);
  }
  
  )
    
  }
}
