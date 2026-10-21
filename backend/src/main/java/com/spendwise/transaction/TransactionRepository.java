package com.spendwise.transaction;
import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.List;
public interface TransactionRepository extends JpaRepository<Transaction,Long> { List<Transaction> findAllByDateBetweenOrderByDateDesc(LocalDate start,LocalDate end); }
