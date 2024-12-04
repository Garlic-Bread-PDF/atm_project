import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';
import { Account } from '../account';

@Component({
  selector: 'app-account',
  imports: [FormsModule],
  templateUrl: './account.component.html',
  styleUrl: './account.component.css'
})
export class AccountComponent {
  account: Account = { accountNumber: '', pinNumber: '', balance: 0 };
  depositAmount: number = 1;
  withdrawalAmount: number = 1;
  elementToShow: string = 'none';

  constructor(private router: Router, private accountService: AccountService) {
    const currentNav = this.router.getCurrentNavigation();
    if (currentNav?.extras?.state?.['accountNumber'] && currentNav?.extras?.state?.['pinNumber']) {
      this.accountService.getAccountByAccountNumberAndPin({ accountNumber: currentNav?.extras?.state?.['accountNumber'], pinNumber: currentNav?.extras?.state?.['pinNumber'] }).subscribe({
        next: (response) => this.account = response,
        error: (error) => alert(error.message)
      });
    } else this.router.navigate(['/login']);
  }

  makeDeposit() {
    this.accountService.updateAccount({ ...this.account, balance: (this.account.balance || 0) + Number(this.depositAmount.toFixed(2)) }).subscribe({
      next: (response) => this.account = response,
      error: (error) => alert(error.message)
    });
  }

  makeWithdrawal() {
    this.accountService.updateAccount({ ...this.account, balance: (this.account.balance || 0) - Number(this.withdrawalAmount.toFixed(2)) }).subscribe({
      next: (response) => this.account = response,
      error: (error) => alert(error.message)
    });
  }
}
