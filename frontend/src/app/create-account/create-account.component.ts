import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AccountService } from '../account.service';
import { FormsModule } from '@angular/forms';
import { Account } from '../account';

@Component({
  selector: 'app-create-account',
  imports: [FormsModule, RouterLink],
  templateUrl: './create-account.component.html',
  styleUrl: './create-account.component.css'
})
export class CreateAccountComponent {
  account: Account = { accountNumber: '', pinNumber: '', balance: 0 };
  accountAlreadyExists: boolean = false;

  constructor(private router: Router, private accountService: AccountService) {}

  onSubmit() {
    this.accountService.addAccount(this.account).subscribe({
      next: (response) => {
        // Redirect to the account page if the given account doesn't already exist
        if (response) this.router.navigateByUrl('/account', { state: { accountNumber: response.accountNumber, pinNumber: response.pinNumber }});
        // Display an error message if the given account already exists
        else this.accountAlreadyExists = true;
      },
      error: (error) => alert(error.message)
    });
  }
}
