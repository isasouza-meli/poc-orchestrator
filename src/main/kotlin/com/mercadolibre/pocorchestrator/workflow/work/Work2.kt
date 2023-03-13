package com.mercadolibre.pocorchestrator.workflow.work

import com.mercadolibre.conductor.works.UnitOfWork
import com.mercadolibre.conductor.works.UnitOfWorkType
import org.jeasy.flows.work.WorkContext
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class Work2 : UnitOfWork(UnitOfWorkType.REPEATABLE) {

  override fun performWork(workContext: WorkContext) {
    println("Work 2")
  }
}