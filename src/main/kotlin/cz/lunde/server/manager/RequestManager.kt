package cz.lunde.server.manager

import cz.lunde.server.model.Request
import cz.lunde.server.repository.RequestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class RequestManager(
    @Autowired var requestRepository: RequestRepository
) {
    fun getAll() =
        requestRepository.findAll()

    fun getById(id: Long) =
        requestRepository.findByIdOrNull(id)

    fun save(request: Request) =
        requestRepository.save(request)

    fun update(request: Request) =
        getById(request.id)?.let { requestRepository.save(request) }

    fun delete(@PathVariable id: Long): Boolean {
        return getById(id)?.let {
            requestRepository.delete(it)
            true
        } ?: false
    }
}