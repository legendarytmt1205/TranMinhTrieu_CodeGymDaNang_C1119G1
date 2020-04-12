import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder, Validators} from '@angular/forms';
import { ServiceService} from '../../../services/service.service';
import { Router,ActivatedRoute} from '@angular/router'

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {
  public formEditService: FormGroup;
  public serviceOfId;

  constructor(
    public formBuilder: FormBuilder,
    public serviceService: ServiceService,
    public router : Router,
    public activeRouter: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formEditService = this.formBuilder.group({
      serviceName:['',[Validators.required]],
      code:['',[Validators.required,Validators.pattern('^(DV)-[a-zA-Z0-9]{4}$')]],
      area:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      numberOfFloors:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      maximumNumberOfPeople:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      rentalCosts:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      rentalTypeCode:['',[Validators.required,Validators.pattern('^[0-9]*$')]],
      status:['',[Validators.required]]
    })

    this.activeRouter.params.subscribe(data =>{
      this.serviceOfId = data.id;
      this.serviceService.getServiceById(this.serviceOfId).subscribe(data =>{
        this.formEditService.patchValue(data);
      })
    })
  }

  editService(){
    this.serviceService.editService(this.formEditService.value,this.serviceOfId).subscribe(data =>{
      this.router.navigateByUrl('service-list');
    })
  }


}
