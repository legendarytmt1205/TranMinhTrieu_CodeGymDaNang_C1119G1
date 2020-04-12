import { Component, OnInit, Inject } from '@angular/core';
import {MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog';
import {CustomerService} from '../../../services/customer.service'

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {
  public customerOfFullName;
  public customerOfId;

  constructor(
    public dialogRef: MatDialogRef<CustomerDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data:any,
    public customerService: CustomerService,
  ) { }

  ngOnInit(): void {
    this.customerOfFullName = this.data.data1.fullName;
    this.customerOfId = this.data.data1.id;

  }

  deleteCustomer(){
    this.customerService.deleteCustomer(this.customerOfId).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
