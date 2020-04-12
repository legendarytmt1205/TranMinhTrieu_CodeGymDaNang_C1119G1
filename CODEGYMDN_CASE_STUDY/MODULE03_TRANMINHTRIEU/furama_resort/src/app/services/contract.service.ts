import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  public API : string ='http://localhost:3000/contracts'

  constructor(
    public http:HttpClient
  ) { }

  getAllContracts(): Observable<any> {
    return this.http.get(this.API);
  }

  addNewwContract(contract): Observable<any>{
    return this.http.post(this.API, contract);
  }

  getContractById(contractId): Observable<any>{
    return this.http.get(this.API + '/' + contractId);
  }

  deleteContract(contractId): Observable<any>{
    return this.http.delete(this.API + '/' + contractId);
  }

  editContract(contract, contractId): Observable<any>{
    return this.http.put(this.API + '/' + contractId,contract);
  }
}
