package org.sam.mines.address.api.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param name 
 * @param postCode 
 * @param id 
 */
data class Town (

        @get:NotNull 
        @JsonProperty("name") val name: kotlin.String,

        @get:NotNull 
        @JsonProperty("postCode") val postCode: kotlin.String,

        @JsonProperty("id") val id: kotlin.String? = null
) {

}

