package com.mercadolibre.pocorchestrator.entity

import java.time.OffsetDateTime

data class Flow (
  var executionDate: OffsetDateTime,
  var execution: Any? = null
)