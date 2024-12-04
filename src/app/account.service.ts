import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Account } from "./account";
import { environment } from "../environments/environment";

@Injectable({ providedIn: 'root' })
export class AccountService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(`${this.apiServerUrl}/account/all`);
  }

  public getAccountByAccountNumberAndPin(account: Account): Observable<Account> {
    let params = new HttpParams();
    params = params.set('accountNumber', account.accountNumber);
    params = params.set('pinNumber', account.pinNumber) ;
    return this.http.get<Account>(`${this.apiServerUrl}/account/get-account`, { params });
  }

  public addAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(`${this.apiServerUrl}/account/add`, account);
  }

  public updateAccount(account: Account): Observable<Account> {
    return this.http.put<Account>(`${this.apiServerUrl}/account/update`, account);
  }

  public deleteAccount(accountNumber: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/account/delete/${accountNumber}`);
  }
}