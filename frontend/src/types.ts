export type TransactionType = 'INCOME' | 'EXPENSE';
export interface Transaction { id:number; title:string; amount:number; type:TransactionType; category:string; date:string; paymentMethod:string; notes?:string; }
export type TransactionInput = Omit<Transaction,'id'>;
