import { Component, OnInit,Inject } from '@angular/core';
import {MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ContractService} from '../../../services/contract.service'
@Component({
  selector: 'app-contract-delete',
  templateUrl: './contract-delete.component.html',
  styleUrls: ['./contract-delete.component.css']
})
export class ContractDeleteComponent implements OnInit {

  public contractOfId;

  constructor(
    public dialogRef: MatDialogRef<ContractDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data:any,
    public contractService: ContractService,
  ) { }

  ngOnInit(): void {
    this.contractOfId = this.data.data1.id;

  }

  deleteContract(){
    this.contractService.deleteContract(this.contractOfId).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
