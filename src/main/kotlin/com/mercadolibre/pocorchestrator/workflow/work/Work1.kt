package com.mercadolibre.pocorchestrator.workflow.work

import com.mercadolibre.conductor.works.UnitOfWork
import com.mercadolibre.conductor.works.UnitOfWorkType
import com.mercadolibre.pocorchestrator.workflow.UseCaseBeanMapper
import org.jeasy.flows.work.WorkContext

class Work1 : UnitOfWork(UnitOfWorkType.REPEATABLE) {

  override fun performWork(workContext: WorkContext) {
    UseCaseBeanMapper.pocUseCase.execute()
  }
}