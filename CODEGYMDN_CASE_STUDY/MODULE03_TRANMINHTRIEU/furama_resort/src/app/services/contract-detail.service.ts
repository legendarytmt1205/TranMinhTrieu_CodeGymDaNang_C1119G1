import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractDetailService {
    public API: string ='http://localhost:3000/contractDetail'

  constructor(
    public http: HttpClient
  ) { }
  getAllContractDetail(): Observable<any> {
    return this.http.get(this.API);
  }

  addNewContractDetail(contractDetail): Observable<any>{
    return this.http.post(this.API, contractDetail);
  }

  getContractDetailById(contractDetailId): Observable<any>{
    return this.http.get(this.API + '/' + contractDetailId);
  }

  deleteContractDetail(contractDetailId): Observable<any>{
    return this.http.delete(this.API + '/' + contractDetailId);
  }

  editContractDetail(contractDetail, contractDetailId): Observable<any>{
    return this.http.put(this.API + '/' + contractDetailId,contractDetail);
  }
}
