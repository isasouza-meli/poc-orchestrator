package com.mercadolibre.pocorchestrator.workflow

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object ThreadPool {
  private lateinit var executorService: ExecutorService
  private const val NUMBER_THREADS = 1

  fun getExecutorService(): ExecutorService {
    if (!this::executorService.isInitialized) {
      return Executors.newFixedThreadPool(NUMBER_THREADS)
    }
    return executorService
  }

  fun setExecutorService(executorService: ExecutorService) {
    this.executorService = executorService
  }
}