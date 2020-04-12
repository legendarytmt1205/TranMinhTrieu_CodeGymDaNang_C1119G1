import { Component, OnInit } from '@angular/core';
import {FormGroup,FormBuilder,Validators} from '@angular/forms';
import {CustomerService} from '../../../services/customer.service';
import {Router} from '@angular/router';
import {APP_DATE_FORMATS,AppDateAdapter} from 'src/app/format-datepicker';
import {DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css'],
  providers:[
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class CustomerAddComponent implements OnInit {
  public formAddNewCustomer : FormGroup

  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router
  ) { }

  ngOnInit(): void {
    this.formAddNewCustomer = this.formBuilder.group({
      fullName:['',[Validators.required]],
      code:['',[Validators.required,Validators.pattern('^(KH)-[a-zA-Z0-9]{4}$')]],
      dateOfBirth:['',[Validators.required]],
      IDnumber:['',[Validators.required,Validators.pattern('^[0-9]{9}$')]],
      email:['',[Validators.required,Validators.email]],
      phone:['',[Validators.required,Validators.pattern('^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$')]],
      address:['',[Validators.required]]
  })
}

addNewCustomer(){
    
  this.customerService.addNewwCustomer(this.formAddNewCustomer.value).subscribe(data =>{
    this.router.navigateByUrl('customer-list');
  })

  console.log(this.formAddNewCustomer)
}
}
