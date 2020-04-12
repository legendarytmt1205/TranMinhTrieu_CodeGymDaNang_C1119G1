import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators} from '@angular/forms';
import { EmployeeService} from '../../../services/employee.service';
import { Router}from '@angular/router';
import {APP_DATE_FORMATS,AppDateAdapter } from 'src/app/format-datepicker';
import { DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';


@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css'],
  providers:[
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class EmployeeAddComponent implements OnInit {
  public formAddNewEmployee: FormGroup

  constructor(
    public formBuilder: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router
  ) { }

  ngOnInit(): void {
    this.formAddNewEmployee = this.formBuilder.group({
      fullName:['',[Validators.required]],
      position:['',[Validators.required]],
      academicLevel:['',[Validators.required]],
      part:['',[Validators.required]],
      dateOfBirth:['',[Validators.required]],
      IDnumber:['',[Validators.required,Validators.pattern('^[0-9]{9}$')]],
      salary:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      email:['',[Validators.required,Validators.email]],
      phone:['',[Validators.required,Validators.pattern('^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$')]],
      address:['',[Validators.required]]

    })
  }

  addNewEmployee(){
    
    this.employeeService.addNewwEmployee(this.formAddNewEmployee.value).subscribe(data =>{
      this.router.navigateByUrl('employee-list');
    })

    console.log(this.formAddNewEmployee)
  }

}
