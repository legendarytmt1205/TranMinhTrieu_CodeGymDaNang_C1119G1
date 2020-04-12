import { Component, OnInit,Inject } from '@angular/core';
import { MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ContractDetailService} from '../../../services/contract-detail.service';

@Component({
  selector: 'app-contract-detail-delete',
  templateUrl: './contract-detail-delete.component.html',
  styleUrls: ['./contract-detail-delete.component.css']
})
export class ContractDetailDeleteComponent implements OnInit {
  public contractDetailId;

  constructor(
    public dialogRef: MatDialogRef<ContractDetailDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data:any,
    public contractDetailService: ContractDetailService,
  ) { }

  
  ngOnInit(): void {
    this.contractDetailId = this.data.data1.id;

  }

  deleteContractDetail(){
    this.contractDetailService.deleteContractDetail(this.contractDetailId).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
