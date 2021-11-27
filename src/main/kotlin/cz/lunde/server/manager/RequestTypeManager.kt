package cz.lunde.server.manager

import cz.lunde.server.dto.RequestTypeDto
import cz.lunde.server.dto.ResponseDto
import cz.lunde.server.repository.RequestTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class RequestTypeManager(
    @Autowired val requestTypeRepository: RequestTypeRepository
) {
    fun getAll() =
        requestTypeRepository.findAll()
            .map { RequestTypeDto(it.id, it.name) }

    fun getById(id: Long) =
        requestTypeRepository.findByIdOrNull(id)
            ?.let { RequestTypeDto(it.id, it.name) }
            ?: ResponseDto("Request type with id '$id' not found!")

    fun save(requestTypeDto: RequestTypeDto) =
        requestTypeRepository.save(requestTypeDto.toModel())
            .let { RequestTypeDto(it.id, it.name) }

    fun delete(@PathVariable id: Long) =
        requestTypeRepository.deleteById(id)
}