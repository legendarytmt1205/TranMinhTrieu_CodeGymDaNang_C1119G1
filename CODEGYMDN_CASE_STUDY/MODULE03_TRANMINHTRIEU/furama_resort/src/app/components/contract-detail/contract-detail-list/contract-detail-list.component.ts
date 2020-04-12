import { Component, OnInit } from '@angular/core';
import { ContractDetailService} from 'src/app/services/contract-detail.service';
import { MatDialog} from '@angular/material/dialog';
import { DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/format-datepicker';
import { ContractDetailDeleteComponent} from '../contract-detail-delete/contract-detail-delete.component';
@Component({
  selector: 'app-contract-detail-list',
  templateUrl: './contract-detail-list.component.html',
  styleUrls: ['./contract-detail-list.component.css'],
  providers:[
    {provide:DateAdapter,useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class ContractDetailListComponent implements OnInit {
  public p;
  public search;
  public contractDetails;

  constructor(
    public contractDetailService: ContractDetailService,
    public dialog:MatDialog
  ) { }

  ngOnInit(): void {
    this.contractDetailService.getAllContractDetail().subscribe(data =>{
      this.contractDetails = data;
      console.log(this.contractDetails);
    })
  }


  openDialog(contractDetailId): void {
    this.contractDetailService.getContractDetailById(contractDetailId).subscribe(dataOfContractDetail =>{
      const dialogRef = this.dialog.open(ContractDetailDeleteComponent, {
        width: '500px',
        data: {data1: dataOfContractDetail},
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