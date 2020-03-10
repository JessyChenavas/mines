package org.sam.mines.address.service

import org.sam.mines.address.model.Town
import java.util.*

interface TownService {
    fun getAll(): List<Town>

    operator fun get(uuid: UUID): Town?

    fun save(town: Town): Town

    fun delete(uuid: UUID)
}