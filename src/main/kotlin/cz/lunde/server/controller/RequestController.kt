package cz.lunde.server.controller

import cz.lunde.server.dto.ResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/contact-form")
class RequestController {

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok().body(ResponseDto("Contact form with id $id"))
    }
}