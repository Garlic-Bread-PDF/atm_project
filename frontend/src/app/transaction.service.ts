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

  // Get all transactions for the given account
  // This is a post request instead of a get request to allow passing the account object as a param
  public getTransactions(account: Account): Observable<Transaction[]> {
    return this.http.post<Transaction[]>(`${this.apiServerUrl}/transaction/get-transactions`, account);
  }

  // Create the given transaction
  public addTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(`${this.apiServerUrl}/transaction/add`, transaction);
  }
}