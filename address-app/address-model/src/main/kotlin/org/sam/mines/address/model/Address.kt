package org.sam.mines.address.model

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Address (
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true, nullable = false)
    @Type(type = "pg-uuid")
    var uuid: UUID? = null,
    @Column(name = "number")
    var number: Int? = null,
    @Column(name = "street")
    var street: @NotBlank String? = null,
    @ManyToOne
    var town: @NotNull Town? = null,
    @ManyToMany
    @JoinTable(name = "targetaddress", joinColumns = [JoinColumn(name = "address_uuid", referencedColumnName = "uuid")], inverseJoinColumns = [JoinColumn(name = "target_uuid", referencedColumnName = "uuid")])
    var targets: Set<Target>? = null

)