package com.mercadolibre.pocorchestrator.workflow.flow

import com.mercadolibre.pocorchestrator.workflow.FlowNames
import com.mercadolibre.pocorchestrator.workflow.WorkFlowExecutor
import com.mercadolibre.pocorchestrator.workflow.interfaces.FlowBuilder
import com.mercadolibre.pocorchestrator.workflow.interfaces.FlowHandler
import org.springframework.stereotype.Component

@Component
class PocFlowHandler(
  private val pocFlowBuilder: FlowBuilder,
  private val workFlowExecutor: WorkFlowExecutor
) : FlowHandler {


  override fun executeFlow(contextValues: Map<String, Any>) {
    executePocFlow(contextValues, FlowNames.POC, pocFlowBuilder)
  }

  private fun executePocFlow(contextValues: Map<String, Any>, eventName: String, flowBuilder: FlowBuilder) {
    val workFlow = flowBuilder.createFlowInstance()
    val workContext = createWorkflowContext(contextValues)
    workFlowExecutor.execute(workFlow, workContext, eventName)
  }
}
