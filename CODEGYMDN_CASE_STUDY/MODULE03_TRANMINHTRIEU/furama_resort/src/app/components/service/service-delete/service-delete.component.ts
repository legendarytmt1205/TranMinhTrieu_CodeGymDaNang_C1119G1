import { Component, OnInit,Inject } from '@angular/core';
import { MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ServiceService} from '../../../services/service.service';


@Component({
  selector: 'app-service-delete',
  templateUrl: './service-delete.component.html',
  styleUrls: ['./service-delete.component.css']
})
export class ServiceDeleteComponent implements OnInit {
  public serviceOfName;
  public serviceOfId;

  constructor(
    public dialogRef: MatDialogRef<ServiceDeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data:any,
    public serviceService: ServiceService

  ) { }

  ngOnInit(): void {
    this.serviceOfName = this.data.data1.serviceName;
    this.serviceOfId = this.data.data1.id;
  }

  deleteService(){
    this.serviceService.deleteService(this.serviceOfId).subscribe(data =>{
      this.dialogRef.close();
    })
  }

}
