import { Component, OnInit } from '@angular/core';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/format-datepicker';
import { CustomerService } from 'src/app/services/customer.service';
import { MatDialog } from '@angular/material/dialog';
import { CustomerDeleteComponent} from '../customer-delete/customer-delete.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css'],
  providers:[
    {provide:DateAdapter,useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class CustomerListComponent implements OnInit {
  public p;
  public search;
  public customers;

  constructor(
    public customerService: CustomerService,
    public dialog:MatDialog
  ) { }

  ngOnInit(): void {
    this.customerService.getAllCustomers().subscribe(data =>{
      this.customers = data;
      console.log(this.customers);
    })
  }


  openDialog(customerId): void {
    this.customerService.getCustomerById(customerId).subscribe(dataOfCustomer =>{
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '500px',
        data: {data1: dataOfCustomer},
        disableClose:true,
      });
  
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
        
      });
    })   
  }

  formatsDateTest: string[] = [
    'dd/MM/yyyy',
   
    ];
  
  dateNow : Date = new Date();
  dateNowISO = this.dateNow.toISOString();
  dateNowMilliseconds = this.dateNow.getTime();

}
