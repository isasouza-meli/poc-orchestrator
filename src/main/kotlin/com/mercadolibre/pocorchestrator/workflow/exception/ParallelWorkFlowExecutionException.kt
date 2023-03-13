package com.mercadolibre.pocorchestrator.workflow.exception

class ParallelWorkFlowExecutionException : Exception {

  constructor(exceptions: List<Throwable>) : super(createErrorMessage(exceptions))

  companion object {
    fun createErrorMessage(exceptions: List<Throwable>): String {
      val message = StringBuilder()
      message.append("Errors occurred during the parallel execution of the Flow: ")
      exceptions.forEach { exception ->
        message.append(" - $exception")
      }
      return message.toString()
    }
  }
}