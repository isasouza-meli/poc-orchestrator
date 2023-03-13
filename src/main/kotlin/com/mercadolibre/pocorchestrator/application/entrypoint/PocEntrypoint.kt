package com.mercadolibre.pocorchestrator.application.entrypoint

import com.mercadolibre.pocorchestrator.controller.interfaces.PocController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.MediaType

@RestController
@RequestMapping("/poc")
class PocEntrypoint(private val pocController: PocController) {

  @GetMapping("/events", produces = [MediaType.APPLICATION_JSON_VALUE])
  fun process() =
    pocController.process()
}