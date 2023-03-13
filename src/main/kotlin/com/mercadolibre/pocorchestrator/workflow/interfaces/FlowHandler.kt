package com.mercadolibre.pocorchestrator.workflow.interfaces

import org.jeasy.flows.work.WorkContext
import org.springframework.stereotype.Component

interface FlowHandler {
  fun createWorkflowContext(contextValues: Map<String, Any>): WorkContext {
    val workContext = WorkContext()
    contextValues.forEach { (key, value) ->
      workContext.put(key, value)
    }
    return workContext
  }

  fun executeFlow(contextValues: Map<String, Any>)
}
