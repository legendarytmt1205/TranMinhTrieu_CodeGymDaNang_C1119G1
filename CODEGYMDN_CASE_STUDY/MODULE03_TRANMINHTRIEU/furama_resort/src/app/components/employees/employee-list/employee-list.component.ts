import { Component, OnInit } from '@angular/core';
import {EmployeeService } from '../../../services/employee.service';
import { MatDialog} from '@angular/material/dialog';
import { EmployeeDeleteDialogComponent} from '../employee-delete-dialog/employee-delete-dialog.component';
import {APP_DATE_FORMATS,AppDateAdapter } from 'src/app/format-datepicker';
import { DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
  providers:[
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class EmployeeListComponent implements OnInit {
  public employees;
  public term;
  public p;
  
  constructor(
    public employeeService: EmployeeService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data =>{
      this.employees = data;
      console.log(this.employees);
    })
  }


  openDialog(employeeId): void {
    this.employeeService.getEmployeeById(employeeId).subscribe(dataOfEmployee =>{
      const dialogRef = this.dialog.open(EmployeeDeleteDialogComponent, {
        width: '500px',
        data: {data1: dataOfEmployee},
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
