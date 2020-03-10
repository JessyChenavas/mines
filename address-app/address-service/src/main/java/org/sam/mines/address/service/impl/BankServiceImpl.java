package org.sam.mines.address.service.impl;

import org.sam.mines.address.model.Bank;
import org.sam.mines.address.persistence.BankRepository;
import org.sam.mines.address.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @Override
    public Optional<Bank> getByUuid(UUID uuid) {
        return bankRepository.findById(uuid);
    }

    @Override
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        bankRepository.deleteById(uuid);
    }
}
