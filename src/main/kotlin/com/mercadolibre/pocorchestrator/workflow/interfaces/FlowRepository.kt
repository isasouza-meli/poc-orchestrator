package com.mercadolibre.pocorchestrator.workflow.interfaces

import com.mercadolibre.pocorchestrator.workflow.entity.Flows

interface FlowRepository {
  fun save(shipmentID: String, flows: Flows)

  fun get(shipmentID: String): Flows
}