package com.mercadolibre.pocorchestrator.application.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.mercadolibre.json.JsonUtils
import com.mercadolibre.json_jackson.JsonJackson
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class JacksonConfig() {

  @Bean
  @Primary
  fun getObjectMapper(): ObjectMapper {
    val objectMapper = (JsonUtils.INSTANCE.engine as JsonJackson).mapper
    configureObjectMapper(objectMapper)
    return objectMapper
  }

  private fun configureObjectMapper(objectMapper: ObjectMapper) {
    objectMapper.findAndRegisterModules()
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    objectMapper.disable(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS)
    objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    objectMapper.propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
    objectMapper.registerKotlinModule()
    objectMapper.registerModule(JavaTimeModule())
  }

}
