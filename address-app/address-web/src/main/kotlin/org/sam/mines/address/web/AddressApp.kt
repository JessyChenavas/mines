package org.sam.mines.address.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication(scanBasePackages = ["org.sam.mines.address"])
@EnableJpaRepositories(basePackages = ["org.sam.mines.address.persistence"])
@EntityScan(basePackages = ["org.sam.mines.address.model"])
@EnableTransactionManagement
class AddressApp

fun main(args: Array<String>) {
    runApplication<AddressApp>(*args)
}

