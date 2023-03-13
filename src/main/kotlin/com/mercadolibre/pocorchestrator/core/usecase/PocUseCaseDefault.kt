package com.mercadolibre.pocorchestrator.core.usecase

import com.mercadolibre.pocorchestrator.core.interfaces.usecase.PocUseCase
import org.springframework.stereotype.Service

@Service
class PocUseCaseDefault: PocUseCase {
  override fun execute() {
   println("test")
  }
}