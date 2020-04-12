import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ContractService} from '../../../services/contract.service';
import {APP_DATE_FORMATS,AppDateAdapter} from 'src/app/format-datepicker';
import {DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';

@Component({
  selector: 'app-contract-add',
  templateUrl: './contract-add.component.html',
  styleUrls: ['./contract-add.component.css'],
  providers:[
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class ContractAddComponent implements OnInit {
  public formAddNewContract: FormGroup

  constructor(
    public formBuilder:FormBuilder,
              public contractService:ContractService,
              public router:Router
  ) { }
  ngOnInit(): void {
    this.formAddNewContract = this.formBuilder.group({
      NVcode: ['', [Validators.required,Validators.pattern('^(NV)-[a-zA-Z0-9]{4}$')]],
      KHcode: ['', [Validators.required, Validators.pattern('^(KH)-[a-zA-Z0-9]{4}$')]],
      DVcode: ['', [Validators.required, Validators.pattern('^(DV)-[a-zA-Z0-9]{4}$')]],
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]],
      deposit: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      total: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
  })
}

  addNewContract(){
    
    this.contractService.addNewwContract(this.formAddNewContract.value).subscribe(data =>{
      this.router.navigateByUrl('contract-list');
    })
  
    console.log(this.formAddNewContract)
  }

}
