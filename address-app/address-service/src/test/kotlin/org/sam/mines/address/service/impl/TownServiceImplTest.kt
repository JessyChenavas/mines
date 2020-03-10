package org.sam.mines.address.service.impl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.sam.mines.address.model.Town
import org.sam.mines.address.persistence.TownRepository
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class TownServiceImplTest {

    @InjectMocks
    private lateinit var townService: TownServiceImpl

    @Mock
    private lateinit var townRepository: TownRepository

    @Test
    fun shouldGetAll(){
        // MOCKS
        Mockito.`when`(townRepository.findAll()).thenReturn(listOf(
                Town(UUID.randomUUID(), 34000, "Montpellier")))

        // TEST
        val all = townService.getAll()

        assertEquals(1, all.size)
    }
}