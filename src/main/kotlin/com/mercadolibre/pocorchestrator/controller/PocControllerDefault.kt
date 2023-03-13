package com.mercadolibre.pocorchestrator.controller

import com.mercadolibre.pocorchestrator.controller.interfaces.PocController
import com.mercadolibre.pocorchestrator.workflow.flow.PocFlowHandler
import com.mercadolibre.pocorchestrator.workflow.interfaces.FlowHandler
import org.springframework.stereotype.Component

@Component
class PocControllerDefault(private val pocFlowHandler: FlowHandler): PocController {
  override fun process() {
    pocFlowHandler.executeFlow(mutableMapOf())
  }
}