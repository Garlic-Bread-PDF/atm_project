import { Component, OnInit } from '@angular/core';
import { Account } from './account';
import { AccountService } from './account.service';
import { HttpErrorResponse } from '@angular/common/http';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'atmprojectapp';

  public accounts!: Account[];

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.getAccounts();
  }

  public getAccounts(): void {
    this.accountService.getAccounts().subscribe({
      next: (response: Account[]) => this.accounts = response,
      error: (error: HttpErrorResponse) => alert(error.message)
    })
  }
}
