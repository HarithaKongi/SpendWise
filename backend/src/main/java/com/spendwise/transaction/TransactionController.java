package com.spendwise.transaction;import jakarta.validation.Valid;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api/transactions") public class TransactionController{private final TransactionService service;public TransactionController(TransactionService s){service=s;}
@GetMapping public List<Transaction> list(@RequestParam(required=false)String month,Authentication a){return service.list(month,a.getName());}
@PostMapping public Transaction create(@Valid @RequestBody TransactionRequest r,Authentication a){return service.create(r,a.getName());}
@PutMapping("/{id}") public Transaction update(@PathVariable Long id,@Valid @RequestBody TransactionRequest r,Authentication a){return service.update(id,r,a.getName());}
@DeleteMapping("/{id}") public void delete(@PathVariable Long id,Authentication a){service.delete(id,a.getName());}}