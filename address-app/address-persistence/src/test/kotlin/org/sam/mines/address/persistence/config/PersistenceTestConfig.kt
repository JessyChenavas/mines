package org.sam.mines.address.persistence.config

import org.apache.commons.dbcp2.BasicDataSource
import org.hibernate.cfg.AvailableSettings
import org.hibernate.tool.schema.Action
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.hibernate5.SpringSessionContext
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = ["org.sam.mines.address.persistence"])
@EntityScan(basePackages = ["org.sam.mines.address.model"])
@EnableTransactionManagement
class PersistenceTestConfig {
    @Bean
    fun dataSource(): DataSource = BasicDataSource()
            .apply {
                driverClassName = "org.hsqldb.jdbcDriver"
                url = "jdbc:hsqldb:mem:mytestdb;sql.syntax_pgs=true"
                username = "sa"
                password = ""
            }

    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val emf = LocalContainerEntityManagerFactoryBean()
        emf.dataSource = dataSource()
        emf.setPackagesToScan("org.sam.mines.address.model")
        emf.jpaVendorAdapter = HibernateJpaVendorAdapter()
        val jpaProperties = Properties()
        jpaProperties[AvailableSettings.DIALECT] = CustomHsqlDialect::class.java.name
        jpaProperties[AvailableSettings.HBM2DDL_DATABASE_ACTION] = Action.CREATE_ONLY
        jpaProperties[AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS] = SpringSessionContext::class.java.name
        emf.setJpaProperties(jpaProperties)
        return emf
    }

    @Bean
    fun transactionManager(): PlatformTransactionManager = JpaTransactionManager(entityManagerFactory().getObject()!!)


    companion object {
        @Bean
        fun placeHolderConfigurer(): PropertySourcesPlaceholderConfigurer = PropertySourcesPlaceholderConfigurer()

    }
}
