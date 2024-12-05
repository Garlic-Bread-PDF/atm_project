import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Account } from "./account";
import { environment } from "../environments/environment";

@Injectable({ providedIn: 'root' })
export class AccountService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  // Get the account with the given account number and pin
  // Used for login
  public getAccountByAccountNumberAndPin(account: Account): Observable<Account> {
    let params = new HttpParams();
    params = params.set('accountNumber', account.accountNumber);
    params = params.set('pinNumber', account.pinNumber) ;
    return this.http.get<Account>(`${this.apiServerUrl}/account/get-account`, { params });
  }

  // Create the given account
  public addAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(`${this.apiServerUrl}/account/add`, account);
  }

  // Update the given account
  public updateAccount(account: Account): Observable<Account> {
    return this.http.put<Account>(`${this.apiServerUrl}/account/update`, account);
  }

  // Delete the given account
  // Not currently used
  public deleteAccount(accountNumber: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/account/delete/${accountNumber}`);
  }
}