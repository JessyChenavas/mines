package org.sam.mines.address.service;

import org.sam.mines.address.model.Bank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankService {

    List<Bank> getAll();

    Optional<Bank> getByUuid(UUID uuid);

    Bank save(Bank bank);

    void deleteByUuid(UUID uuid);
}
