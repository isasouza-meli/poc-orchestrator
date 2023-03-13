package com.mercadolibre.pocorchestrator.workflow.interfaces

import org.jeasy.flows.workflow.WorkFlow

interface FlowBuilder {
  fun createFlowInstance(): WorkFlow
}