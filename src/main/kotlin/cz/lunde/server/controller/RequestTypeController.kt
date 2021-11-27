package cz.lunde.server.controller

import cz.lunde.server.dto.RequestTypeDto
import cz.lunde.server.dto.ResponseDto
import cz.lunde.server.manager.RequestTypeManager
import cz.lunde.server.mapper.RequestMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/request-type")
class RequestTypeController(
    @Autowired var requestTypeManager: RequestTypeManager,
    @Autowired var requestMapper: RequestMapper
) {

    @GetMapping
    fun getAll() =
        requestTypeManager.getAll()
            .map { it.toDto() }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long) =
        requestTypeManager.getById(id)
            ?.let { ResponseEntity.ok(it.toDto()) }
            ?: notExistingResponseTypeResponse(id)

    @PostMapping
    fun add(@Valid @RequestBody requestTypeDto: RequestTypeDto) =
        requestTypeManager.save(requestTypeDto.toModel()).toDto()

    @PutMapping
    fun update(@Valid @RequestBody requestTypeDto: RequestTypeDto) =
        requestTypeManager.update(requestTypeDto.toModel())
            ?.let { ResponseEntity.ok(it.toDto()) }
            ?: notExistingResponseTypeResponse(requestTypeDto.id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        if (requestTypeManager.delete(id))
            ResponseEntity.ok(ResponseDto("Request type with '$id' removed."))
        else
            notExistingResponseTypeResponse(id)

    private fun notExistingResponseTypeResponse(id: Long) =
        ResponseEntity.badRequest().body(ResponseDto("Request type with '$id' not found."))
}