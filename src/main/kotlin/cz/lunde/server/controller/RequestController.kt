package cz.lunde.server.controller

import cz.lunde.server.dto.RequestDto
import cz.lunde.server.dto.ResponseDto
import cz.lunde.server.manager.RequestManager
import cz.lunde.server.mapper.RequestMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/request")
class RequestController(
    @Autowired var requestManager: RequestManager,
    @Autowired var requestMapper: RequestMapper
) {

    @GetMapping
    fun getAll() =
        requestManager.getAll()
            .map(requestMapper::toDto)

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long) =
        requestManager.getById(id)
            ?.let { ResponseEntity.ok(requestMapper.toDto(it)) }
            ?: notExistingRequestResponse(id)

    @PostMapping
    fun add(@Valid @RequestBody requestDto: RequestDto) =
        requestManager.save(requestMapper.toModel(requestDto))
            .let(requestMapper::toDto)

    @PutMapping
    fun update(@Valid @RequestBody requestDto: RequestDto) =
        requestManager.update(requestMapper.toModel(requestDto))
            ?.let(requestMapper::toDto)
            ?: notExistingRequestResponse(requestDto.id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        if (requestManager.delete(id))
            ResponseEntity.ok(ResponseDto("Request with id: '$id' removed."))
        else
            notExistingRequestResponse(id)

    private fun notExistingRequestResponse(id: Long) =
        ResponseEntity.badRequest().body(ResponseDto("Request with '$id' not found."))
}