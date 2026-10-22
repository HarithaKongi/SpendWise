package com.spendwise.transaction;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="transactions") public class Transaction {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=100) private String title;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal amount;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=10) private TransactionType type;
 @Column(nullable=false,length=60) private String category;
 @Column(nullable=false) private LocalDate date;
 @Column(nullable=false,length=40) private String paymentMethod;
 @Column(length=300) private String notes;
 @Column(name="user_email",length=254) private String userEmail;
 protected Transaction() {}
 public Long getId(){return id;} public String getTitle(){return title;} public BigDecimal getAmount(){return amount;} public TransactionType getType(){return type;} public String getCategory(){return category;} public LocalDate getDate(){return date;} public String getPaymentMethod(){return paymentMethod;} public String getNotes(){return notes;} public String getUserEmail(){return userEmail;}
 public void setTitle(String v){title=v;} public void setAmount(BigDecimal v){amount=v;} public void setType(TransactionType v){type=v;} public void setCategory(String v){category=v;} public void setDate(LocalDate v){date=v;} public void setPaymentMethod(String v){paymentMethod=v;} public void setNotes(String v){notes=v;} public void setUserEmail(String v){userEmail=v;}
}
