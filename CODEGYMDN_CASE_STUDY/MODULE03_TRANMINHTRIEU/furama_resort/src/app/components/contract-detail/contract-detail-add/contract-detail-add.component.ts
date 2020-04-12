import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup,Validators} from '@angular/forms';
import { Router} from '@angular/router';
import { ContractDetailService} from '../../../services/contract-detail.service';
import {APP_DATE_FORMATS,AppDateAdapter} from 'src/app/format-datepicker';
import {DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';

@Component({
  selector: 'app-contract-detail-add',
  templateUrl: './contract-detail-add.component.html',
  styleUrls: ['./contract-detail-add.component.css'],
  providers:[
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class ContractDetailAddComponent implements OnInit {
  public formAddNewContractDetails: FormGroup;

  constructor(
    public formBuilder:  FormBuilder,
    public contractDetailService: ContractDetailService,
    public router :Router
  ) { }

  ngOnInit(): void {
    this.formAddNewContractDetails = this.formBuilder.group({
      HDcode: ['', [Validators.required,Validators.pattern('^(HD)-[a-zA-Z0-9]{4}$')]],
      DVcode: ['', [Validators.required, Validators.pattern('^(DV)-[a-zA-Z0-9]{4}$')]],
      amount: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      
  })
  }

  addNewContractDetail(){
    
    this.contractDetailService.addNewContractDetail(this.formAddNewContractDetails.value).subscribe(data =>{
      this.router.navigateByUrl('contract-detail-list');
    })
  
  }

}


