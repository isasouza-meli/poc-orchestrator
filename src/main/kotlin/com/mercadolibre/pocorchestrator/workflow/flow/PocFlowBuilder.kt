package com.mercadolibre.pocorchestrator.workflow.flow

import com.mercadolibre.pocorchestrator.workflow.FlowNames
import com.mercadolibre.pocorchestrator.workflow.interfaces.FlowBuilder
import com.mercadolibre.pocorchestrator.workflow.work.Work1
import com.mercadolibre.pocorchestrator.workflow.work.Work2
import org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow
import org.jeasy.flows.workflow.WorkFlow
import org.springframework.stereotype.Component

@Component
class PocFlowBuilder : FlowBuilder {

  override fun createFlowInstance(): WorkFlow =
    aNewSequentialFlow()
      .named(FlowNames.POC)
      .execute(Work1())
      .then(Work2())
      .build()

}
