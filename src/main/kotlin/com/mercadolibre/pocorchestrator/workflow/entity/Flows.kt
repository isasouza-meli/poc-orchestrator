package com.mercadolibre.pocorchestrator.workflow.entity


data class Flows (
  var workflows: MutableMap<String, Flow> = mutableMapOf(),
)