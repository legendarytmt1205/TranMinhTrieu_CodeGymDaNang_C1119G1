import { Component, OnInit } from '@angular/core';
import { NotificationService} from '../../../services/notification.service'
import { ContractService } from 'src/app/services/contract.service';
import { MatDialog } from '@angular/material/dialog';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/format-datepicker';
import { ContractDeleteComponent } from '../contract-delete/contract-delete.component';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css'],
  providers:[
    {provide:DateAdapter,useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class ContractListComponent implements OnInit {
  public p;
  public search;
  public contracts;

  constructor(
    public contractService: ContractService,
    public dialog:MatDialog
  ) { }

  ngOnInit(): void {
    this.contractService.getAllContracts().subscribe(data =>{
      this.contracts = data;
      console.log(this.contracts);
    })
  }


  openDialog(contractId): void {
    this.contractService.getContractById(contractId).subscribe(dataOfContract =>{
      const dialogRef = this.dialog.open(ContractDeleteComponent, {
        width: '500px',
        data: {data1: dataOfContract},
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
