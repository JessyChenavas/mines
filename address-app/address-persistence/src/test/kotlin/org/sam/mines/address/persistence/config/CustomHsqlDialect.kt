package org.sam.mines.address.persistence.config

import org.hibernate.boot.model.TypeContributions
import org.hibernate.dialect.HSQLDialect
import org.hibernate.service.ServiceRegistry
import org.hibernate.type.AbstractSingleColumnStandardBasicType
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor
import java.sql.Types
import java.util.*

class CustomHsqlDialect : HSQLDialect() {
    override fun contributeTypes(typeContributions: TypeContributions, serviceRegistry: ServiceRegistry) {
        super.contributeTypes(typeContributions, serviceRegistry)
        typeContributions.contributeType(UUIDType())
    }

    init {
        this.registerColumnType(Types.JAVA_OBJECT, "varchar(10000)")
    }
}

class UUIDType : AbstractSingleColumnStandardBasicType<UUID>(VarcharTypeDescriptor.INSTANCE, UUIDTypeDescriptor.INSTANCE) {
    override fun getName(): String = "pg-uuid"
}
