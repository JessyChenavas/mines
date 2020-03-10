package org.sam.mines.address.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sam.mines.address.model.Bank;
import org.sam.mines.address.persistence.BankRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest {

    @Mock
    private BankRepository bankRepository;

    private BankServiceImpl bankService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        bankService = new BankServiceImpl(bankRepository);
    }

    @Test
    void shouldGetAll(){
        // MOCKS
        Mockito.when(bankRepository.findAll()).thenReturn(List.of(new Bank(UUID.randomUUID(),"18401", "Caisse Epargne","572 avenue du Viget")));

        // TEST
        List<Bank> bankList = bankService.getAll();

        assertEquals(1, bankList.size());
    }


    @Test
    void shouldGetById(){
        // MOCKS
        Mockito.when(bankRepository.findById(any(UUID.class))).thenReturn(Optional.of(new Bank(UUID.randomUUID(),"18401", "Caisse Epargne","572 avenue du Viget")));

        // TEST
        Optional<Bank> bankList = bankService.getByUuid(UUID.randomUUID());

        assertFalse(bankList.isEmpty());
    }

    @Test
    void shouldNotGetById(){
        // MOCKS
        Mockito.when(bankRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        // TEST
        Optional<Bank> bankList = bankService.getByUuid(UUID.randomUUID());

        assertTrue(bankList.isEmpty());
    }
}