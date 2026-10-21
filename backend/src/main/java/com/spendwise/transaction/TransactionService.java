package com.spendwise.transaction;
import org.springframework.http.HttpStatus; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import org.springframework.web.server.ResponseStatusException; import java.time.LocalDate; import java.util.List;
@Service public class TransactionService {
 private final TransactionRepository repository; public TransactionService(TransactionRepository repository){this.repository=repository;}
 public List<Transaction> list(String month){if(month==null||month.isBlank())return repository.findAll().stream().sorted((a,b)->b.getDate().compareTo(a.getDate())).toList();try{LocalDate start=LocalDate.parse(month+"-01");return repository.findAllByDateBetweenOrderByDateDesc(start,start.withDayOfMonth(start.lengthOfMonth()));}catch(RuntimeException e){throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Month must use yyyy-MM format");}}
 @Transactional public Transaction create(TransactionRequest r){Transaction t=new Transaction();apply(t,r);return repository.save(t);}
 @Transactional public Transaction update(Long id,TransactionRequest r){Transaction t=repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found"));apply(t,r);return repository.save(t);}
 public void delete(Long id){if(!repository.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found");repository.deleteById(id);}
 private void apply(Transaction t,TransactionRequest r){t.setTitle(r.title().trim());t.setAmount(r.amount());t.setType(r.type());t.setCategory(r.category().trim());t.setDate(r.date());t.setPaymentMethod(r.paymentMethod().trim());t.setNotes(r.notes()==null||r.notes().isBlank()?null:r.notes().trim());}
}
