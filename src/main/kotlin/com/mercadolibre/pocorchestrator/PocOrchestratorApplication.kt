package com.mercadolibre.pocorchestrator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PocOrchestratorApplication

fun main(args: Array<String>) {
	runApplication<PocOrchestratorApplication>(*args)
}
