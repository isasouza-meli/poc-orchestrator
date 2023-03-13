package com.mercadolibre.pocorchestrator.workflow.service

import org.jeasy.flows.work.WorkContext

fun <T> WorkContext.getAsClass(contextKey: String): T = this.get(contextKey) as T