package com.mercadolibre.pocorchestrator.workflow.work

import com.mercadolibre.conductor.works.UnitOfWork
import com.mercadolibre.conductor.works.UnitOfWorkType
import com.mercadolibre.pocorchestrator.core.interfaces.PocUseCase
import org.jeasy.flows.work.WorkContext
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class Work1(
  private val pocUseCase: PocUseCase,
) : UnitOfWork(UnitOfWorkType.REPEATABLE) {

  override fun performWork(workContext: WorkContext) {
    pocUseCase.execute()
  }
}