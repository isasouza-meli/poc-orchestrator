package com.mercadolibre.pocorchestrator.entity


data class Flows (
  var workflows: MutableMap<String, Flow> = mutableMapOf(),
)