package com.mercadolibre.pocorchestrator.application.registry

import com.mercadolibre.pocorchestrator.workflow.UseCaseBeanMapper
import com.mercadolibre.pocorchestrator.workflow.UseCaseBeanMapper.pocUseCase
import org.springframework.beans.factory.getBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseBeanRegistry(
  private val applicationContext: ApplicationContext
) {
  @Bean
  fun getUseCaseBeanMapper(): UseCaseBeanMapper {
    pocUseCase = applicationContext.getBean()
    return UseCaseBeanMapper
  }
}
