import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  public API : string = 'http://localhost:3000/services';

  constructor(
    public http: HttpClient
  ) { }

  getAllServices(): Observable<any>{
    return this.http.get(this.API);
  }

  addNewService(service): Observable<any>{
    return this.http.post(this.API, service);
  }

  getServiceById(serviceId): Observable<any>{
    return this.http.get(this.API + '/' + serviceId);
  }

  deleteService(serviceId): Observable<any>{
    return this.http.delete(this.API +'/' + serviceId);
  }

  editService(service,serviceId): Observable<any>{
    return this.http.put(this.API +'/' + serviceId,service);
  }
}
