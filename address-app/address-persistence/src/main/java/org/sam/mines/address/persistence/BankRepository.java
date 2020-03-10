package org.sam.mines.address.persistence;

import org.sam.mines.address.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {
}
