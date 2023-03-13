package com.mercadolibre.pocorchestrator.functional

import com.github.tomakehurst.wiremock.WireMockServer

import com.mercadolibre.pocorchestrator.PocOrchestratorApplication
import com.mercadolibre.pocorchestrator.application.JacksonConfig
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [PocOrchestratorApplication::class, JacksonConfig::class])
@AutoConfigureWireMock(port = 0)
abstract class FunctionalTest {

  @Autowired
  lateinit var wireMockServer: WireMockServer

  @Autowired
  lateinit var restTemplate: TestRestTemplate

  @AfterEach
  fun afterEach() {
    wireMockServer.resetAll()
  }

}
