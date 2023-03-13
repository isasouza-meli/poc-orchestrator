package com.mercadolibre.pocorchestrator.workflow

import com.mercadolibre.conductor.workflows.WorkflowExecution
import com.mercadolibre.conductor.works.NonRepeatableUnitOfWorkAlreadyExecutedException
import com.mercadolibre.pocorchestrator.workflow.exception.ParallelWorkFlowExecutionException
import org.jeasy.flows.engine.WorkFlowEngineBuilder
import org.jeasy.flows.work.WorkContext
import org.jeasy.flows.work.WorkReport
import org.jeasy.flows.work.WorkStatus
import org.jeasy.flows.workflow.ParallelFlowReport
import org.jeasy.flows.workflow.WorkFlow
import org.springframework.stereotype.Component

@Component
class WorkFlowExecutor() {

  fun execute(workflow: WorkFlow, workflowContext: WorkContext, flowName: String) {
    val workflowExecution = getWorkFlowExecution(flowName, workflow)
    try {
      checkReportError(
        workflowExecution.execute(
          flowName,
          workflowContext,
          WorkFlowEngineBuilder.aNewWorkFlowEngine().build()
        )
      )
    } finally {
      saveWorkFlowExecution()
    }
  }


  private fun getWorkFlowExecution(flowName: String, workflow: WorkFlow): WorkflowExecution =
    WorkflowExecution(flowName, workflow)


  private fun saveWorkFlowExecution() = println("saving")

  private fun checkReportError(workReport: WorkReport) =
    if (workReport is ParallelFlowReport) {
      checkParallelReportError(workReport)
    } else {
      checkDefaultReportError(workReport)
    }

  private fun checkParallelReportError(workReport: ParallelFlowReport) {
    workReport.reports.filter {
      it.status == WorkStatus.FAILED && it.error !is NonRepeatableUnitOfWorkAlreadyExecutedException
    }.map { it.error }.takeIf {
      it.isNotEmpty()
    }?.apply { throw ParallelWorkFlowExecutionException(this) }
  }

  private fun checkDefaultReportError(workReport: WorkReport) {
    if (workReport.error != null && workReport.error !is NonRepeatableUnitOfWorkAlreadyExecutedException) {
      throw workReport.error
    }
  }
}