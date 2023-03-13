package com.mercadolibre.pocorchestrator.functional


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders

@SuppressWarnings("LargeClass")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PocFlowTest : FunctionalTest() {

  @Test
  fun `Test Poc flow`() {
    get()
  }

  private fun get() =
    restTemplate.getForEntity("/poc/events", String::class.java)

}
