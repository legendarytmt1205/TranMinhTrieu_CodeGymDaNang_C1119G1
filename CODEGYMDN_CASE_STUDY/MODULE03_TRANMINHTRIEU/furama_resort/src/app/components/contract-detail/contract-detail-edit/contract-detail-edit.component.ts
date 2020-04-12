import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup,Validators} from '@angular/forms';
import { ContractDetailService} from '../../../services/contract-detail.service';
import {ActivatedRoute, Router} from '@angular/router';
import {APP_DATE_FORMATS,AppDateAdapter} from 'src/app/format-datepicker';
import {DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';

@Component({
  selector: 'app-contract-detail-edit',
  templateUrl: './contract-detail-edit.component.html',
  styleUrls: ['./contract-detail-edit.component.css'],
  providers:[
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class ContractDetailEditComponent implements OnInit {
  public formEditContractDetail: FormGroup;
  public contractDetaildId

  constructor(
    public formBuilder:   FormBuilder,
    public contractDetailService: ContractDetailService,
    public router: Router,
    public activateRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEditContractDetail = this.formBuilder.group({
      HDcode: ['', [Validators.required,Validators.pattern('^(HD)-[a-zA-Z0-9]{4}$')]],
      DVcode: ['', [Validators.required, Validators.pattern('^(DV)-[a-zA-Z0-9]{4}$')]],
      amount: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      
  })
  this.activateRouter.params.subscribe(data =>{
    this.contractDetaildId = data.id;
    this.contractDetailService.getContractDetailById(this.contractDetaildId).subscribe(data =>{
      this.formEditContractDetail.patchValue(data);
    })
  })
  }

  editContractDetail(){
    
    this.contractDetailService.editContractDetail(this.formEditContractDetail.value,this.contractDetaildId).subscribe(data =>{
      this.router.navigateByUrl('contract-detail-list');
    })
  
  }

}
