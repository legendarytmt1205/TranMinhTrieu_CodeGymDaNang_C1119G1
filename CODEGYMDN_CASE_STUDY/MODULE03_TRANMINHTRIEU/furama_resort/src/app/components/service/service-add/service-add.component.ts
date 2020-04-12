import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder, Validators} from '@angular/forms';
import { ServiceService} from '../../../services/service.service';
import { Router} from '@angular/router'

@Component({
  selector: 'app-service-add',
  templateUrl: './service-add.component.html',
  styleUrls: ['./service-add.component.css']
})
export class ServiceAddComponent implements OnInit {
  public formAddNewService: FormGroup

  constructor(
    public formBuilder: FormBuilder,
    public serviceService: ServiceService,
    public router : Router
  ) { }

  ngOnInit(): void {
    this.formAddNewService = this.formBuilder.group({
      serviceName:['',[Validators.required]],
      code:['',[Validators.required,Validators.pattern('^(DV)-[a-zA-Z0-9]{4}$')]],
      area:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      numberOfFloors:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      maximumNumberOfPeople:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      rentalCosts:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      rentalTypeCode:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      status:['',[Validators.required]]
    })
  }

  addNewService(){
    this.serviceService.addNewService(this.formAddNewService.value).subscribe(data =>{
      this.router.navigateByUrl('service-list');
    })
  }

}
