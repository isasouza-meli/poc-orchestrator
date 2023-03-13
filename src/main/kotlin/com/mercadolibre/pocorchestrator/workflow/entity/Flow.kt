package com.mercadolibre.pocorchestrator.workflow.entity

import java.time.OffsetDateTime

data class Flow (
  var executionDate: OffsetDateTime,
  var execution: Any? = null
)