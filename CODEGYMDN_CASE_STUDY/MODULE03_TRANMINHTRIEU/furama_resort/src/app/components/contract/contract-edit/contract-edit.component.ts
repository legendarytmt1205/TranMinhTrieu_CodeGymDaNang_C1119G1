import { Component, OnInit } from '@angular/core';
import {FormGroup,FormBuilder, Validators } from '@angular/forms';
import {ContractService } from '../../../services/contract.service';
import {ActivatedRoute, Router} from '@angular/router';
import {APP_DATE_FORMATS,AppDateAdapter} from 'src/app/format-datepicker';
import {DateAdapter,MAT_DATE_FORMATS} from '@angular/material/core';
@Component({
  selector: 'app-contract-edit',
  templateUrl: './contract-edit.component.html',
  styleUrls: ['./contract-edit.component.css'],
  providers:[
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue:APP_DATE_FORMATS }
  ]
})
export class ContractEditComponent implements OnInit {
  public formEditContract : FormGroup;
  public contractOfId;

  constructor(
    public formBuilder: FormBuilder,
    public contractService: ContractService,
    public router: Router,
    public activateRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEditContract = this.formBuilder.group({
      NVcode: ['', [Validators.required,Validators.pattern('^(NV)[\\-][0-9]{4}$')]],
      KHcode: ['', [Validators.required, Validators.pattern('^(KH)[\\-][0-9]{4}$')]],
      DVcode: ['', [Validators.required, Validators.pattern('^(DV)[\\-][0-9]{4}$')]],
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]],
      deposit: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      total: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
  })

    this.activateRouter.params.subscribe(data =>{
      this.contractOfId = data.id;
      this.contractService.getContractById(this.contractOfId).subscribe(data =>{
        this.formEditContract.patchValue(data);
      })
    })
  }
    editContract(){
     this.contractService.editContract(this.formEditContract.value,this.contractOfId).subscribe(data =>{
       this.router.navigateByUrl('contract-list');
      })
    }
}
