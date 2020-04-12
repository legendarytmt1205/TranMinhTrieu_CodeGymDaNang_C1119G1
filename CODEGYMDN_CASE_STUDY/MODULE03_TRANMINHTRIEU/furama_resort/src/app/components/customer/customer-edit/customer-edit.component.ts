import { Component, OnInit } from '@angular/core';
import {FormGroup,FormBuilder, Validators } from '@angular/forms';
import {CustomerService } from '../../../services/customer.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  public formEditCustomer : FormGroup;
  public customerOfId;

  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public activateRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEditCustomer = this.formBuilder.group({
      fullName:['',[Validators.required]],
      code:['',[Validators.required,Validators.pattern('^(KH)-[a-zA-Z0-9]{4}$')]],
      dateOfBirth:['',[Validators.required]],
      IDnumber:['',[Validators.required,Validators.pattern('^[0-9]{9}$')]],
      email:['',[Validators.required,Validators.email]],
      phone:['',[Validators.required,Validators.pattern('^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$')]],
      address:['',[Validators.required]]
    })

    this.activateRouter.params.subscribe(data =>{
      this.customerOfId = data.id;
      this.customerService.getCustomerById(this.customerOfId).subscribe(data =>{
        this.formEditCustomer.patchValue(data);
      })
    })
  }
    editCustomer(){
      this.customerService.editCustomer(this.formEditCustomer.value,this.customerOfId).subscribe(data =>{
        this.router.navigateByUrl('customer-list');
      })
    }
}
