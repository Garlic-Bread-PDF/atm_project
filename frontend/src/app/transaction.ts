import { Account } from "./account";

export interface Transaction {
  type: string,
  amount: number,
  account: Account,
  date: Date
}