package org.sam.mines.address.web.controller

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.sam.mines.address.model.Town
import org.sam.mines.address.service.TownService
import org.sam.mines.address.web.config.WebTestConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@WebMvcTest(TownController::class)
@Import(WebTestConfig::class)
internal class TownControllerTest @Autowired constructor(private val mockMvc: MockMvc) {

    @Autowired
    private lateinit var townService: TownService

    @Test
    fun shouldGetATown() {
        // Given
        val uuid = UUID.randomUUID()

        // When
        Mockito.`when`(townService[uuid]).thenReturn(Town(UUID.randomUUID(), 1, "some town"))

        // Then
        mockMvc.perform(MockMvcRequestBuilders.get("/town/$uuid").accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("some town"))
    }

    @Test
    fun shouldNotGetInstanceData() {
        mockMvc.perform(MockMvcRequestBuilders.get("/instance/${UUID.randomUUID()}/data").accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isNotFound)
    }
}