package org.sam.mines.address.persistence;

import org.sam.mines.address.model.Bank;
import org.sam.mines.address.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
abstract class CreditCardRepository implements JpaRepository<CreditCard, String> {
}
