package org.sam.mines.address.persistence;

import org.sam.mines.address.model.Bank;
import org.sam.mines.address.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
abstract class TransactionRepository implements JpaRepository<Transaction, String> {
}
