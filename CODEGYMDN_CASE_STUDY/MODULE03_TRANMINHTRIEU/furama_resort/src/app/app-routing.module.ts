import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { EmployeeListComponent } from './components/employees/employee-list/employee-list.component';
import { CommonModule } from '@angular/common';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { EmployeeAddComponent } from './components/employees/employee-add/employee-add.component';
import { MaterialModule} from './material.module';
import { EmployeeDeleteDialogComponent } from './components/employees/employee-delete-dialog/employee-delete-dialog.component';
import { EmployeeEditComponent } from './components/employees/employee-edit/employee-edit.component';
import { CustomerListComponent } from './components/customer/customer-list/customer-list.component';
import { CustomerDeleteComponent } from './components/customer/customer-delete/customer-delete.component';
import { CustomerAddComponent } from './components/customer/customer-add/customer-add.component';
import { CustomerEditComponent } from './components/customer/customer-edit/customer-edit.component';
import { ServiceListComponent } from './components/service/service-list/service-list.component';
import { ServiceDeleteComponent } from './components/service/service-delete/service-delete.component';
import { ServiceAddComponent } from './components/service/service-add/service-add.component';
import { ServiceEditComponent } from './components/service/service-edit/service-edit.component';
import { ContractListComponent } from './components/contract/contract-list/contract-list.component';
import { ContractDeleteComponent } from './components/contract/contract-delete/contract-delete.component';
import { ContractAddComponent } from './components/contract/contract-add/contract-add.component';
import { ContractEditComponent } from './components/contract/contract-edit/contract-edit.component';
import { ContractDetailListComponent } from './components/contract-detail/contract-detail-list/contract-detail-list.component';
import { ContractDetailDeleteComponent } from './components/contract-detail/contract-detail-delete/contract-detail-delete.component';
import { ContractDetailAddComponent } from './components/contract-detail/contract-detail-add/contract-detail-add.component';
import { ContractDetailEditComponent } from './components/contract-detail/contract-detail-edit/contract-detail-edit.component';



const routes: Routes = [
  {path: '',component:HomeComponent},
  {path: 'employee-list',component:EmployeeListComponent},
  {path: 'employee-add',component:EmployeeAddComponent},
  {path: 'employee-edit/:id',component:EmployeeEditComponent},
  {path: 'customer-list',component:CustomerListComponent},
  {path: 'customer-add',component:CustomerAddComponent},
  {path: 'customer-edit/:id',component:CustomerEditComponent},
  {path: 'service-list',component:ServiceListComponent},
  {path: 'service-add',component:ServiceAddComponent},
  {path: 'service-edit/:id',component:ServiceEditComponent},
  {path: 'contract-list',component:ContractListComponent},
  {path: 'contract-add',component:ContractAddComponent},
  {path: 'contract-edit/:id',component:ContractEditComponent},
  {path: 'contract-detail-list',component:ContractDetailListComponent},
  {path: 'contract-detail-add',component:ContractDetailAddComponent},
  {path: 'contract-detail-edit/:id',component:ContractDetailEditComponent},


  {path: '**',component:PageNotFoundComponent},
];

@NgModule({
  declarations:[HomeComponent, PageNotFoundComponent, 
    EmployeeListComponent, 
    EmployeeAddComponent, EmployeeDeleteDialogComponent, 
    EmployeeEditComponent, CustomerListComponent,
     CustomerDeleteComponent, CustomerAddComponent,
      CustomerEditComponent, ServiceListComponent,
       ServiceDeleteComponent, ServiceAddComponent,
        ServiceEditComponent, ContractListComponent,
         ContractDeleteComponent, ContractAddComponent,
          ContractEditComponent,
          ContractDetailListComponent,
          ContractDetailDeleteComponent,
          ContractDetailAddComponent,
          ContractDetailEditComponent],
  imports: [RouterModule.forRoot(routes),MaterialModule,ReactiveFormsModule,NgxPaginationModule,CommonModule,Ng2SearchPipeModule,FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
