package cz.lunde.server.controller

import cz.lunde.server.dto.RequestTypeDto
import cz.lunde.server.manager.RequestTypeManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/request-type")
class RequestTypeController(
    @Autowired var requestTypeManager: RequestTypeManager
) {

    @GetMapping
    fun getAll() =
        requestTypeManager.getAll()

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long) =
        requestTypeManager.getById(id)

    @PostMapping
    fun addType(@Valid @RequestBody requestTypeDto: RequestTypeDto) =
        requestTypeManager.save(requestTypeDto)

    @PutMapping
    fun updateType(@Valid @RequestBody requestTypeDto: RequestTypeDto) =
        requestTypeManager.save(requestTypeDto)

    @DeleteMapping("/{id}")
    fun deleteType(@PathVariable id: Long) =
        requestTypeManager.delete(id)

}