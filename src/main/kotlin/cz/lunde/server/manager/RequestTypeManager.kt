package cz.lunde.server.manager

import cz.lunde.server.model.RequestType
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

    fun getById(id: Long) =
        requestTypeRepository.findByIdOrNull(id)

    fun save(requestType: RequestType) =
        requestTypeRepository.save(requestType)

    fun update(requestType: RequestType) =
        getById(requestType.id)?.let { requestTypeRepository.save(requestType) }

    fun delete(@PathVariable id: Long) =
        getById(id)?.let {
            requestTypeRepository.delete(it)
            true
        } ?: false
}