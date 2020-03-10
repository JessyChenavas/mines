package org.sam.mines.address.web;

import org.sam.mines.address.model.Bank;
import org.sam.mines.address.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("bank")
public class BankController {

    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<Bank> getBanks() {
        return bankService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Bank> getBank(@PathVariable UUID uuid) {
        return bankService.getByUuid(uuid);
    }


    @PostMapping
    public void saveBank(Bank bank) {
        bankService.save(bank);
    }

}
