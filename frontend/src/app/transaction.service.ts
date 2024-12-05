import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "../environments/environment";
import { Transaction } from "./transaction";
import { Account } from "./account";

@Injectable({ providedIn: 'root' })
export class TransactionService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getTransactions(account: Account): Observable<Transaction[]> {
    return this.http.post<Transaction[]>(`${this.apiServerUrl}/transaction/get-transactions`, account);
  }

  public addTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(`${this.apiServerUrl}/transaction/add`, transaction);
  }
}