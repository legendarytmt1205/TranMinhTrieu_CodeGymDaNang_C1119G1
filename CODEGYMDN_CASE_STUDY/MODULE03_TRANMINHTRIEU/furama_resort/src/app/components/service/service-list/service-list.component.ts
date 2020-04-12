import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/services/service.service';
import { MatDialog } from '@angular/material/dialog';
import { ServiceDeleteComponent } from '../service-delete/service-delete.component';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {
  public services;
  public p;
  public term;

  constructor(
    public serviceService: ServiceService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.serviceService.getAllServices().subscribe(data =>{
      this.services = data;
    })
  }

  openDialog(serviceId): void {
    this.serviceService.getServiceById(serviceId).subscribe(dataOfService =>{
      const dialogRef = this.dialog.open(ServiceDeleteComponent,{
        width: '500px',
        data: {data1:dataOfService},
        disableClose: true,
      });

      dialogRef.afterClosed().subscribe(result =>{
        this.ngOnInit();
      })
    })
  }

}
