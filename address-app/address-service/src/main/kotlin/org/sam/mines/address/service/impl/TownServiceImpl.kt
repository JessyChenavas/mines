package org.sam.mines.address.service.impl

import org.sam.mines.address.model.Town
import org.sam.mines.address.persistence.TownRepository
import org.sam.mines.address.service.TownService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TownServiceImpl @Autowired constructor(val townRepository: TownRepository) : TownService {
    override fun getAll(): List<Town> = townRepository.findAll()

    override fun get(uuid: UUID): Town? = townRepository.findById(uuid).orElse(null)

    override fun save(town: Town): Town = townRepository.save(town)

    override fun delete(uuid: UUID) = townRepository.deleteById(uuid)
}