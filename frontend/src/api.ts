import axios from 'axios';
import type { Transaction, TransactionInput } from './types';
const api = axios.create({baseURL: import.meta.env.VITE_API_URL || 'http://localhost:8080',headers:{'Content-Type':'application/json'}});
export const transactionsApi = {
 list:(month:string)=>api.get<Transaction[]>('/api/transactions',{params:{month}}).then(r=>r.data),
 create:(data:TransactionInput)=>api.post<Transaction>('/api/transactions',data).then(r=>r.data),
 remove:(id:number)=>api.delete(`/api/transactions/${id}`)
};
