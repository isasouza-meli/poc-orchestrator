package com.mercadolibre.pocorchestrator.workflow.work

import com.mercadolibre.conductor.works.UnitOfWork
import com.mercadolibre.conductor.works.UnitOfWorkType
import org.jeasy.flows.work.WorkContext

class Work2 : UnitOfWork(UnitOfWorkType.REPEATABLE) {

  override fun performWork(workContext: WorkContext) {
    println("Work 2")
  }
}