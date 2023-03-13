package com.mercadolibre.pocorchestrator.core.interfaces

import com.mercadolibre.pocorchestrator.entity.Flows

interface FlowRepository {
  fun save(shipmentID: String, flows: Flows)

  fun get(shipmentID: String): Flows
}