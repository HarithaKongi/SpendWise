package com.spendwise.transaction;
import jakarta.validation.constraints.*; import java.math.BigDecimal; import java.time.LocalDate;
public record TransactionRequest(@NotBlank @Size(max=100) String title,@NotNull @DecimalMin("0.01") @Digits(integer=10,fraction=2) BigDecimal amount,@NotNull TransactionType type,@NotBlank @Size(max=60) String category,@NotNull LocalDate date,@NotBlank @Size(max=40) String paymentMethod,@Size(max=300) String notes) {}
