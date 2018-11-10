package us.team7pro.EventTicketsApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import us.team7pro.EventTicketsApp.Models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
