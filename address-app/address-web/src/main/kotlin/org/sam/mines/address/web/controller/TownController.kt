package org.sam.mines.address.web.controller

import org.sam.mines.address.api.controller.TownApi
import org.sam.mines.address.api.model.Town
import org.sam.mines.address.service.TownService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*


@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping
class TownController @Autowired constructor(val townService: TownService) : TownApi {
    override fun create(town: Town): ResponseEntity<Town> =
            townService.save(town.map())
                    .map()
                    .let {
                        val location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                                "/{id}").buildAndExpand(it.id).toUri()

                        ResponseEntity.created(location).body(it)
                    }

    override fun get(id: String): ResponseEntity<Town> =
            townService[UUID.fromString(id)]
                    ?.map()
                    ?.let { ResponseEntity.ok(it) }
                    ?: ResponseEntity.notFound().build()


    override fun list(): ResponseEntity<List<Town>> = townService.getAll()
            .map { it.map() }
            .let { ResponseEntity.ok(it) }

    override fun delete(id: String): ResponseEntity<String> =
            townService[UUID.fromString(id)]
                    ?.uuid
                    ?.also(townService::delete)
                    ?.let { ResponseEntity.ok(id) }
                    ?: ResponseEntity.notFound().build()

    override fun update(town: Town): ResponseEntity<Town> =
            townService[UUID.fromString(town.id)]
                    ?.let { townService.save(town.map()) }
                    ?.let { ResponseEntity.ok(it.map()) }
                    ?: ResponseEntity.notFound().build()

    fun Town.map() =
            org.sam.mines.address.model.Town(
                    uuid = this.id?.let{UUID.fromString(it)},
                    name = this.name,
                    postcode = this.postCode.toInt()

            )

    fun org.sam.mines.address.model.Town.map() =
            Town(id = this.uuid?.toString(), name = this.name!!, postCode = this.postcode.toString())

}